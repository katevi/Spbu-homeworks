package g144.Vinnik;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import static g144.Vinnik.GameParams.*;

public class ServerCannon extends Canvas implements Runnable {
    private Thread gameThread;
    private Background background = new Background(0,0,0);
    private Cannon serverCannon = new Cannon(220,GAME_HEIGHT - 100 - 30,1);
    private Cannon clientCannon = new Cannon(100,GAME_HEIGHT - 100 - 30,1);
    private ServerGame server;
    private ClientGame client;
    private boolean isRunning;
    private final ArrayList<Bullet> bullets = new ArrayList<>();

    /** Creates new window with given size. */
    public ServerCannon() {
        //client = new ClientGame("192.168.1.4");
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

    /** {@inheritDoc} */
    @Override
    protected void onKeyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            // serverCannon.getX() - left top corner of serverCannon image, serverCannon.getCannonWidth / 2 - half of width serverCannon image, 4 - half of bullet radius
            bullets.add(new Bullet(serverCannon.getX() + serverCannon.getCannonWidth() / 2 - 4, serverCannon.getY(), 1, serverCannon.getAngleInDegrees()));
            //serverCannon.shoot(background);
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            serverCannon.moveLeft(background);
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            serverCannon.moveRight(background);
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            serverCannon.changeSightRight();
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            serverCannon.changeSightLeft();
        }
    }


    /** Draws all bullets flight. */
    @Override
    protected void onDraw(Graphics2D graphics2D) {
        graphics2D.setColor(Color.GREEN);
        background.draw(graphics2D);
        serverCannon.draw(graphics2D);
        clientCannon.draw(graphics2D);
        if (bullets != null) {
            for (Bullet bullet : bullets) {
                bullet.draw(graphics2D);
            }
        }
    }

    /** {@inheritDoc} */
    @Override
    public void run() {
        init();
        String command;
        while (isRunning) {
            long startTime = System.currentTimeMillis();
            server.send(serverCannon.getX() + " " + serverCannon.getY());
            command = server.receive();
            parseCommand(command);

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
        server = new ServerGame();
        System.out.println("Created server socket");
    }

    private void renderGame() {
        repaint();
    }

    private void updateGame() {
        for (int i = 0; i < bullets.size(); i++) {
            Bullet bullet = bullets.get(i);
            bullet.update();
            if (bullet.getY() < 0 || bullet.getX() < 0 || bullet.getX() > GAME_WIDTH || bullet.getY() > GAME_HEIGHT) {
                bullets.remove(bullet);
            }
        }
    }
}
