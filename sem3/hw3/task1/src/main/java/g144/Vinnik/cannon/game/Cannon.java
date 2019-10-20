package g144.Vinnik.cannon.game;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;

import static java.lang.Math.abs;
import static java.lang.Math.ceil;

public class Cannon extends Sprite {
    private final Image image;
    private final int cannonWidth = 40;
    private double directionTan = 0;

    //first coordiante of cannon sight
    private double x1 = getX() + cannonWidth / 2;
    //getY() - coordinate image left top angle  ; left 5 = coordinate left top angle of cannon image - height cannon
    private double y1 = getY() + 5;

    //second coordinate of cannon sight
    private double x2 = x1;
    private double y2;

    private Line2D line = new Line2D.Double(x1, y1, x2, y2);
    private int angleInDegrees = 0;

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
        //x2=((int)(x1*Math.cos(angleInDegrees)))-((int)(y1* Math.sin(angleInDegrees)));
        //y2=((int)(x1*Math.sin(angleInDegrees)))+((int)(y1* Math.cos(angleInDegrees)));
        //graphics2D.drawLine(x1, y1, x2, y2);
        /*line.setLine(getX(), getY(), getX() + Math.cos(Math.PIangleInDegrees), getY() + Math.sin(angleInDegrees));
        graphics2D.draw(line);*/
        //at.invert();
    }

    protected int getAngleInDegrees() {
        return angleInDegrees;
    }

    protected int getCannonWidth() {
        return cannonWidth;
    }

    protected void shoot(Background background) {
        System.out.println("Shooting");
    }


    private void moveUp(double directionTan) {
        setY(getY() - (int) ceil(abs(directionTan)));
        y1 = y1 - abs(directionTan);
        y2 = y2 - abs(directionTan);
        line.setLine(x1, y1, x2, y2);
    }

    private void moveDown(double directionTan) {
        setY(getY() + (int) ceil(abs(directionTan)));
        y1 = y1 + abs(directionTan);
        y2 = y2 + abs(directionTan);
        line.setLine(x1, y1, x2, y2);
    }

    protected void moveLeft(Background background) {
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

    protected void moveRight(Background background) {
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

    protected void changeSightRight() {
        if (angleInDegrees <= 90) {
            angleInDegrees++;
        }
    }

    protected void changeSightLeft() {
        if (angleInDegrees >= -90) {
            angleInDegrees--;
        }
    }

}
