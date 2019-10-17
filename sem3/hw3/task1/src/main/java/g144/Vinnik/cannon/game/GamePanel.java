package g144.Vinnik.cannon.game;

import java.awt.*;
import java.awt.event.KeyEvent;

public class GamePanel extends Canvas implements Runnable {
    private Sprite background = new Background(0,0,0);

    public GamePanel() {
        setPreferredSize(new Dimension(GAME_WIDTH, GAME_HEIGHT));
    }

    @Override
    protected void onKeyUp(KeyEvent e) {

    }

    @Override
    protected void onKeyPressed(KeyEvent e) {

    }

    @Override
    protected void onDraw(Graphics2D graphics2D) {
        graphics2D.setColor(Color.BLUE);
        //graphics2D.drawRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        background.draw(graphics2D);
    }

    @Override
    public void run() {

    }
}
