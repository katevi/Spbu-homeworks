package g144.Vinnik.cannon.game;

import java.awt.*;
import java.awt.event.KeyEvent;

public class GamePanel extends Canvas implements Runnable {
    private Thread gameThread;
    private Background background = new Background(0,0,0);
    private Cannon cannon = new Cannon(220,GAME_HEIGHT - 100 - 30,1);
    private boolean isRunning;

    public GamePanel() {
        setPreferredSize(new Dimension(GAME_WIDTH, GAME_HEIGHT));
    }

    @Override
    public void addNotify() {
        super.addNotify();
        if (gameThread == null) {
            gameThread = new Thread(GamePanel.this);
        }
        gameThread.start();
    }

    @Override
    protected void onKeyUp(KeyEvent e) {

    }

    @Override
    protected void onKeyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            cannon.shoot(background);
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            cannon.moveLeft(background);
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            cannon.moveRight(background);
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            cannon.changeSightRight(background);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            cannon.changeSightLeft(background);
        }
    }

    @Override
    protected void onDraw(Graphics2D graphics2D) {
        graphics2D.setColor(Color.BLUE);
        //graphics2D.drawRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        background.draw(graphics2D);
        cannon.draw(graphics2D);
    }

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

    }
}
