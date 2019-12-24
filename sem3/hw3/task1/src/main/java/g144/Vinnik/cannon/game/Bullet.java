package g144.Vinnik.cannon.game;

import java.awt.*;

public class Bullet extends Sprite {
    private double speedX;
    private double speedY;
    private int timer;

    /** Creates new bullet in the middle of cannon top with given shot direction and given flying speed.*/
    public Bullet(int newX, int newY, int newSpeed, int angleSightCannon) {
        super(newX, newY, newSpeed);
        speedX = getSpeed() * Math.sin(Math.toRadians(angleSightCannon - 90));
        speedY = getSpeed() * Math.cos(Math.toRadians(angleSightCannon - 90));
        timer = 0;
    }

    @Override
    protected void draw(Graphics2D graphics2D) {
        graphics2D.setColor(Color.DARK_GRAY);
        graphics2D.fillOval(getX(), getY(), 8, 8);
    }

    /** Paints bullet flight in current period of time. (Bullet flies in a parabola). */
    protected void update() {
        double g = 0.1;
        setX(getX() + (int) (speedY * timer));
        setY((getY()) + (int) (speedX * timer) + (int) (g * timer * timer / 2));
        timer++;
    }
}
