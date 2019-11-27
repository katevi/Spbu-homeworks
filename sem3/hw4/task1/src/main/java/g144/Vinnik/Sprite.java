package g144.Vinnik;

import java.awt.*;

/** Implements game textures. */
public abstract class Sprite {
    private int x;
    private int y;
    private int speed;

    /** Creates new sprite with given coordinate and speed. */
    public Sprite(int newX, int newY, int newSpeed) {
        this.x = newX;
        this.y = newY;
        this.speed = newSpeed;
    }

    protected abstract void draw(Graphics2D graphics2D);

    /** Returns current x-coordinate of sprite. */
    public int getX() {
        return x;
    }

    /** Sets given x-coordinate to sprite x-coordinate. */
    public void setX(int x) {
        this.x = x;
    }

    /** Returns current y-coordinate of sprite. */
    public int getY() {
        return y;
    }

    /** Sets given y-coordinate to sprite y-coordinate. */
    public void setY(int y) {
        this.y = y;
    }

    /** Returns current sprite speed of moving. */
    public int getSpeed() {
        return speed;
    }

    /** Sets given speed to sprite speed. */
    public void setSpeed(int newSpeed) {
        speed = newSpeed;
    }

}
