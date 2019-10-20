package g144.Vinnik.cannon.game;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/** Implements interaction with user. */
public class GamePanel extends Canvas implements Runnable {
    private Thread gameThread;
    private Background background = new Background(0,0,0);
    private Cannon cannon = new Cannon(220,GAME_HEIGHT - 100 - 30,1);
    private boolean isRunning;
    private final ArrayList<Bullet> bullets = new ArrayList<>();

    /** Creates new window with given size. */
    public GamePanel() {
        setPreferredSize(new Dimension(GAME_WIDTH, GAME_HEIGHT));
    }

    /** {@inheritDoc} */
    @Override
    public void addNotify() {
        super.addNotify();
        if (gameThread == null) {
            gameThread = new Thread(GamePanel.this);
        }
        gameThread.start();
    }

    /** {@inheritDoc} */
    @Override
    protected void onKeyUp(KeyEvent e) {

    }

    /** {@inheritDoc} */
    @Override
    protected void onKeyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            // cannon.getX() - left top corner of cannon image, cannon.getCannonWidth / 2 - half of width cannon image, 4 - half of bullet radius
            bullets.add(new Bullet(cannon.getX() + cannon.getCannonWidth() / 2 - 4, cannon.getY(), 1, cannon.getAngleInDegrees()));
            //cannon.shoot(background);
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            cannon.moveLeft(background);
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            cannon.moveRight(background);
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            cannon.changeSightRight();
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            cannon.changeSightLeft();
        }
    }


    /** Draws all bullets flight. */
    @Override
    protected void onDraw(Graphics2D graphics2D) {
        graphics2D.setColor(Color.GREEN);
        background.draw(graphics2D);
        cannon.draw(graphics2D);
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
        while (isRunning) {
            long startTime = System.currentTimeMillis();
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
