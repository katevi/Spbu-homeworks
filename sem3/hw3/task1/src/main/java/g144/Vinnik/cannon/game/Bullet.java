package g144.Vinnik.cannon.game;

import java.awt.*;

public class Bullet extends Sprite {
    public Bullet(int newX, int newY, int newSpeed) {
        super(newX, newY, newSpeed);
    }

    @Override
    protected void draw(Graphics2D graphics2D) {
        graphics2D.setColor(Color.DARK_GRAY);
        graphics2D.fillOval(getX(), getY(), 8, 8);
    }

    protected void update() {
        setY(getY() - getSpeed());
    }
}
