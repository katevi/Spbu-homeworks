package g144.Vinnik;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.util.ArrayList;

import static g144.Vinnik.GameParams.*;

public class ClientCannon extends Canvas implements Runnable {
    private Thread gameThread;
    private Background background = new Background(0,0,0);
    private Cannon clientCannon = new Cannon(100,GAME_HEIGHT - 100 - 30,1);
    private Cannon serverCannon = new Cannon(220,GAME_HEIGHT - 100 - 30,1);
    /*private ServerGame server;*/
    private ClientGame client;
    private boolean isRunning;
    private String serverIp;
    private String command;
    private final ArrayList<Bullet> bullets = new ArrayList<>();


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
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            // clientCannon.getX() - left top corner of clientCannon image, clientCannon.getCannonWidth / 2 - half of width clientCannon image, 4 - half of bullet radius
            bullets.add(new Bullet(clientCannon.getX() + clientCannon.getCannonWidth() / 2 - 4, clientCannon.getY(), 1, clientCannon.getAngleInDegrees()));
            //clientCannon.shoot(background);
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            clientCannon.moveLeft(background);
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            clientCannon.moveRight(background);
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            clientCannon.changeSightRight();
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            clientCannon.changeSightLeft();
        }
    }


    /** Draws all bullets flight. */
    @Override
    protected void onDraw(Graphics2D graphics2D) {
        graphics2D.setColor(Color.GREEN);
        background.draw(graphics2D);
        clientCannon.draw(graphics2D);
        serverCannon.draw(graphics2D);
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

            client.send( clientCannon.getX() + " " + clientCannon.getY());
            command = client.receive();
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
        client = new ClientGame(serverIp);
        System.out.println("Created client socket");
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
