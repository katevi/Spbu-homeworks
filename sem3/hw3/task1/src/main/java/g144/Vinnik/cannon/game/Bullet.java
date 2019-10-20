package g144.Vinnik.cannon.game;

import java.awt.*;

public class Bullet extends Sprite {
    private double speedX;
    private double speedY;
    private int timer;


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

    protected void update() {
        if ((int) speedX == 1) {
            setY(getY() + getSpeed());
        } else {
            System.out.println("HAHA");
            double g = 0.1;
            setX(getX() + (int) (speedY * timer));
            setY((getY()) + (int) (speedX * timer) + (int) (g * timer * timer / 2));
            System.out.println(getX() + " " + getY() + " " + timer);
            timer++;
        }
    }
}
