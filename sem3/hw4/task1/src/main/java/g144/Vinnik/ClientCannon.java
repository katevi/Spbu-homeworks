package g144.Vinnik;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.security.Key;
import java.util.ArrayList;
import java.util.LinkedList;

import static g144.Vinnik.GameParams.*;

public class ClientCannon extends Canvas implements Runnable {
    private Thread gameThread;
    private Background background = new Background(0,0,0);

    private Cannon clientCannon = new Cannon(100,GAME_HEIGHT - 100 - 30,1);
    private Cannon serverCannon = new Cannon(220,GAME_HEIGHT - 100 - 30,1);

    private ClientGame client;
    private boolean isRunning;
    private String serverIp;

    //private LinkedList<Integer> usedKeys = new LinkedList();

    private final ArrayList<Bullet> clientBullets = new ArrayList<>();
    private final ArrayList<Bullet> serverBullets = new ArrayList<>();


    /** Creates new window with given size. */
    public ClientCannon(String ipAddress) {
        setPreferredSize(new Dimension(GAME_WIDTH, GAME_HEIGHT));
        serverIp = ipAddress;
    }

    /** {@inheritDoc} */
    @Override
    public void addNotify() {
        super.addNotify();
        if (gameThread == null) {
            gameThread = new Thread(ClientCannon.this);
        }
        gameThread.start();
    }

    private void parseCommand(String command) {
        String[] coordinates = command.split(" ");
        serverCannon.setX(Integer.parseInt(coordinates[0]));
        serverCannon.setY(Integer.parseInt(coordinates[1]));
    }

    /** {@inheritDoc} */
    @Override
    protected void onKeyUp(KeyEvent e) {

    }

    /** {@inheritDoc} */
    @Override
    protected void onKeyPressed(KeyEvent e) {
        onKeyPressed(e.getKeyCode(), clientCannon);
        client.send(e.getKeyCode());
    }

    private void onKeyPressed(int code, Cannon cannon) {
        if (code != 0) {
            System.out.println("We are in onkeypressed");
            if (code == KeyEvent.VK_ENTER) {
                // clientCannon.getX() - left top corner of clientCannon image, clientCannon.getCannonWidth / 2 - half of width clientCannon image, 4 - half of bullet radius
                clientBullets.add(new Bullet(clientCannon.getX() + clientCannon.getCannonWidth() / 2 - 4, clientCannon.getY(), 1, clientCannon.getAngleInDegrees()));
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
                System.out.println("VK_DOWN");
            }
            //usedKeys.add(code);
        }
    }

    /** Draws all clientBullets flight. */
    @Override
    protected void onDraw(Graphics2D graphics2D) {
        graphics2D.setColor(Color.GREEN);
        background.draw(graphics2D);
        clientCannon.draw(graphics2D);
        serverCannon.draw(graphics2D);
        if (clientBullets != null) {
            for (Bullet bullet : clientBullets) {
                bullet.draw(graphics2D);
            }
        }
    }

    private void interactWithEnemy() {
        /*for (int i = 0; i < usedKeys.size(); i++) {
            client.send(usedKeys.get(i));
        }*/
        //client.send(usedKeys);
        //usedKeys.clear();
    }

    /** {@inheritDoc} */
    @Override
    public void run() {
        init();
        Integer command;
        while (isRunning) {
            long startTime = System.currentTimeMillis();
            command = client.receive();
            onKeyPressed(command, serverCannon);

            updateGame();
            renderGame();
            long endTime = System.currentTimeMillis() - startTime;
            long waitTime = (MILLISECOND / FPS) - endTime / MILLISECOND;
            try {
                Thread.sleep(waitTime);
            } catch (Exception e) {

            }
        }
    }


    private void init() {
        isRunning = true;
        client = new ClientGame(serverIp);
        System.out.println("Created client socket");
    }

    private void renderGame() {
        repaint();
    }

    private void updateGame() {
        for (int i = 0; i < clientBullets.size(); i++) {
            Bullet bullet = clientBullets.get(i);
            bullet.update();
            if (bullet.getY() < 0 || bullet.getX() < 0 || bullet.getX() > GAME_WIDTH || bullet.getY() > GAME_HEIGHT) {
                clientBullets.remove(bullet);
            }
        }
    }
}
