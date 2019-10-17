package g144.Vinnik.cannon.game;

import java.awt.*;

public abstract class Sprite implements Helper {
    private int x;
    private int y;
    private int speed;

    public Sprite(int newX, int newY, int newSpeed) {
        this.x = newX;
        this.y = newY;
        this.speed = newSpeed;
    }

    protected abstract void draw(Graphics2D graphics2D);

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
