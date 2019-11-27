package g144.Vinnik;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.LinkedList;

import static g144.Vinnik.GameParams.*;

public class ServerCannon extends Canvas implements Runnable {
    private Thread gameThread;
    private Background background = new Background(0,0,0);
    private Cannon serverCannon = new Cannon(220,GAME_HEIGHT - 100 - 30,1);
    private Cannon clientCannon = new Cannon(100,GAME_HEIGHT - 100 - 30,1);
    private ServerGame server;
    private ClientGame client;
    private boolean isRunning;

    //private LinkedList<Integer> usedKeys = new LinkedList<>();
    private final ArrayList<Bullet> serverBullets = new ArrayList<>();
    private final ArrayList<Bullet> clientBullets = new ArrayList<>();

    /** Creates new window with given size. */
    public ServerCannon() {
        setPreferredSize(new Dimension(GAME_WIDTH, GAME_HEIGHT));
    }

    /** {@inheritDoc} */
    @Override
    public void addNotify() {
        super.addNotify();
        if (gameThread == null) {
            gameThread = new Thread(ServerCannon.this);
        }
        gameThread.start();
    }

    /** {@inheritDoc} */
    @Override
    protected void onKeyUp(KeyEvent e) {

    }

    private void parseCommand(String command) {
        String[] coordinates = command.split(" ");
        clientCannon.setX(Integer.parseInt(coordinates[0]));
        clientCannon.setY(Integer.parseInt(coordinates[1]));
    }

    private void onKeyPressed(int code, Cannon cannon) {
        if (code != 0) {
            System.out.println("We are in onkeypressed");
            if (code == KeyEvent.VK_ENTER) {
                // clientCannon.getX() - left top corner of clientCannon image, clientCannon.getCannonWidth / 2 - half of width clientCannon image, 4 - half of bullet radius
                serverBullets.add(new Bullet(serverCannon.getX() + serverCannon.getCannonWidth() / 2 - 4, serverCannon.getY(), 1, serverCannon.getAngleInDegrees()));
                System.out.println("Enter");
            } else if (code == KeyEvent.VK_LEFT) {
                cannon.moveLeft(background);
                System.out.println("VK_LEFT");
            } else if (code == KeyEvent.VK_RIGHT) {
                cannon.moveRight(background);
                System.out.println("VK_RIGHT");
            } else if (code == KeyEvent.VK_UP) {
                cannon.changeSightRight();
                System.out.println("VK_UP");
            } else if (code == KeyEvent.VK_DOWN) {
                cannon.changeSightLeft();
                System.out.println("DOWN");
            }
            System.out.println("Add code" + code);
            //usedKeys.add(code);
            //System.out.println("size after adding new code" + usedKeys.size());
        }
    }

    /** {@inheritDoc} */
    @Override
    protected void onKeyPressed(KeyEvent e) {
        System.out.println("Key pressed");
        onKeyPressed(e.getKeyCode(), serverCannon);
        server.send(e.getKeyCode());
    }

    /** Draws all serverBullets flight. */
    @Override
    protected void onDraw(Graphics2D graphics2D) {
        graphics2D.setColor(Color.GREEN);
        background.draw(graphics2D);
        serverCannon.draw(graphics2D);
        clientCannon.draw(graphics2D);
        if (serverBullets != null) {
            for (Bullet bullet : serverBullets) {
                bullet.draw(graphics2D);
            }
        }
    }

    private void interactWithEnemy() {
        //System.out.println("in interact with enemy" + usedKeys.size());
        /*for (int i = 0; i < usedKeys.size(); i++) {
            System.out.println("Sent commands" + usedKeys.get(i).toString());
            server.send(usedKeys.get(i).toString());
        }*/
        //server.send(usedKeys);
        //usedKeys.clear();
        //System.out.println("usedKeys size" + usedKeys.size());
    }

    /** {@inheritDoc} */
    @Override
    public void run() {
        init();
        int command;
        while (isRunning) {
            System.out.println("in cycle");
            long startTime = System.currentTimeMillis();
            command = server.receive();
            System.out.println("Received from client" + command);
            onKeyPressed(command, clientCannon);

            updateGame();
            renderGame();
            long endTime = System.currentTimeMillis() - startTime;
            long waitTime = (MILLISECOND / FPS) - endTime / MILLISECOND;
            try {
                Thread.sleep(waitTime);
            } catch (Exception e) { }
            interactWithEnemy();
        }
    }

    private void init() {
        isRunning = true;
        server = new ServerGame();
        System.out.println("Created server socket");
    }

    private void renderGame() {
        repaint();
    }

    private void updateGame() {
        for (int i = 0; i < serverBullets.size(); i++) {
            Bullet bullet = serverBullets.get(i);
            bullet.update();
            if (bullet.getY() < 0 || bullet.getX() < 0 || bullet.getX() > GAME_WIDTH || bullet.getY() > GAME_HEIGHT) {
                serverBullets.remove(bullet);
            }
        }
    }
}
