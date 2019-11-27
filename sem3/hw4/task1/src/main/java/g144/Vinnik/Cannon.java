package g144.Vinnik;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;

import static g144.Vinnik.GameParams.*;
import static java.lang.Math.abs;
import static java.lang.Math.ceil;

/** Implements entity cannon. */
public class Cannon extends Sprite {
    private final Image image;
    private final int cannonWidth = 40;
    private double directionTan = 0;

    //first coordiante of shot direction line
    private double x1 = getX() + cannonWidth / 2;
    //getY() - coordinate image left top angle  ; left 5 = coordinate left top angle of cannon image - height cannon
    private double y1 = getY() + 5;

    //second coordinate of shot direction line
    private double x2 = x1;
    private double y2;

    private Line2D line = new Line2D.Double(x1, y1, x2, y2);
    private int angleInDegrees = 0;

    /** Creates cannon at a fixed point on the plane with given speed. */
    public Cannon(int newX, int newY, int newSpeed) {
        super(newX, newY, newSpeed);
        this.image = new ImageIcon(getClass().getResource("/cannon.png")).getImage();
    }

    @Override
    protected void draw(Graphics2D graphics2D) {
        graphics2D.drawImage(this.image, this.getX(), this.getY(), null);

        AffineTransform at =
                AffineTransform.getRotateInstance(
                        Math.toRadians(angleInDegrees), line.getX1(), line.getY1());

        graphics2D.draw(at.createTransformedShape(line));
    }

    protected int getAngleInDegrees() {
        return angleInDegrees;
    }

    protected int getCannonWidth() {
        return cannonWidth;
    }


    /** Implements x offset. */
    public void moveLeft(Background background) {
        if (getX() <= 0) {
            return;
        }
        if (background.isChangePoint(getX())) {
            directionTan = background.returnEquationForLeftDirection(getX());
        }
        if (directionTan > 0) {
            moveUp(directionTan);
        } else if (directionTan < 0) {
            moveDown(directionTan);
        }
        setX(getX() - getSpeed());
        x1 = x1 - getSpeed();
        x2 = x2 - getSpeed();
        line.setLine(x1, y1, x2, y2);
    }

    public void moveRight(Background background) {
        if (getX() >= GAME_WIDTH - cannonWidth) {
            return;
        }
        if (background.isChangePoint(getX())) {
            directionTan = background.returnEquationForRightDirection(getX());
        }

        if (directionTan > 0) {
            moveDown(directionTan);
        } else if (directionTan < 0) {
            moveUp(directionTan);
        }
        setX(getX() + getSpeed());
        x1 = x1 + getSpeed();
        x2 = x2 + getSpeed();
        line.setLine(x1, y1, x2, y2);
    }

    /** Implements y offset. (Used when cannon rides on a mountain). */
    public void moveUp(double directionTan) {
        setY(getY() - (int) ceil(abs(directionTan)));
        y1 = y1 - abs(directionTan);
        y2 = y2 - abs(directionTan);
        line.setLine(x1, y1, x2, y2);
    }

    public void moveDown(double directionTan) {
        setY(getY() + (int) ceil(abs(directionTan)));
        y1 = y1 + abs(directionTan);
        y2 = y2 + abs(directionTan);
        line.setLine(x1, y1, x2, y2);
    }

    /** Changes direction of shot (by clockwise). */
    public void changeSightRight() {
        if (angleInDegrees <= 90) {
            angleInDegrees++;
        }
    }

    /** Implements direction of shot (by clockwise). */
    public void changeSightLeft() {
        if (angleInDegrees >= -90) {
            angleInDegrees--;
        }
    }

}
