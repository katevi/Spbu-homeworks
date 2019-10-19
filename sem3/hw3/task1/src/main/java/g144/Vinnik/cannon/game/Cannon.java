package g144.Vinnik.cannon.game;

import javax.swing.*;
import java.awt.*;

import static java.lang.Math.abs;
import static java.lang.Math.ceil;

public class Cannon extends Sprite {
    private final Image image;
    private final int cannonSize = 40;
    private double directionTan = 0;
    private boolean lastEdgeWasRight = false;

    public Cannon(int newX, int newY, int newSpeed) {
        super(newX, newY, newSpeed);
        this.image = new ImageIcon(getClass().getResource("/cannon.png")).getImage();
    }

    @Override
    protected void draw(Graphics2D graphics2D) {
        graphics2D.drawImage(this.image, this.getX(), this.getY(), null);
    }

    void shoot(Background background) {
        System.out.println("Shooting");
    }


    private void moveUp(double directionTan) {
        setY(getY() - (int) ceil(abs(directionTan)));
    }

    private void moveDown(double directionTan) {
        setY(getY() + (int) ceil(abs(directionTan)));
    }

    void moveLeft(Background background) {
        if (getX() <= 0) {
            return;
        }
        if (background.isChangePoint(getX())) {
            directionTan = background.returnEquationForLeftDirection(getX());
        }

        if (directionTan > 0) {
            moveUp(directionTan);
            setX(getX() - getSpeed());
        } else if (directionTan < 0) {
            moveDown(directionTan);
            setX(getX() - getSpeed());
        } else if (directionTan == 0) {
            setX(getX() - getSpeed());
        }
    }

    void moveRight(Background background) {
        if (getX() >= GAME_WIDTH - cannonSize) {
            return;
        }
        if (background.isChangePoint(getX())) {
            directionTan = background.returnEquationForRightDirection(getX());
        }
        if (directionTan > 0) {
            moveDown(directionTan);
            setX(getX() + getSpeed());
        } else if (directionTan < 0) {
            moveUp(directionTan);
            setX(getX() + getSpeed());
        } else if (directionTan == 0) {
            setX(getX() + getSpeed());
        }
    }

    void changeSightRight(Background background) {
        System.out.println("ChangeSightRight");
    }

    void changeSightLeft(Background background) {
        System.out.println("ChangeSightLeft");
    }

}
