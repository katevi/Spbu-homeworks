package g144.Vinnik;
import javax.swing.*;
import java.awt.*;

/** Generates a map with given coordinates of mountains. */
public class Background extends Sprite {
    private final Image image;

    private final int[] changePointsX = {0, 100, 150, 200, 300, 350, 400, 470, 530, 590, 650};
    private final int[] changePointsY = {400, 400, 300, 400, 400, 350, 400, 400, 340, 400, 400};

    /** Creates background with given image.
     * Speed = 0, as background texture does not move during the game (some background textures moves). */
    public Background(int newX, int newY, int newSpeed) {
        super(newX, newY, newSpeed);
        this.image = new ImageIcon(getClass().getResource("/land.png")).getImage();
    }

    @Override
    protected void draw(Graphics2D graphics2D) {
        graphics2D.drawImage(this.image, getX(), getY(), null);
    }

    /** Returns true, if in given point mountain starts, false otherwise. */
    protected boolean isChangePoint(int x) {
        for (int i = 0; i < changePointsX.length; i++) {
            if (x == changePointsX[i]) {
                return true;
            }
        }
        return false;
    }

    /** Finds nearest left changePoint to given and returns slope of the line, passing through given changePoint and found changePoint. */
    protected double returnEquationForLeftDirection(int firstPointX) {
        double result = 0;

        for (int i = changePointsX.length - 1; i > 0; i--) {
            if (changePointsX[i] < firstPointX) {
                double deltaY = changePointsY[i + 1] - changePointsY[i];
                double deltaX = changePointsX[i + 1] - changePointsX[i];
                result = deltaY / deltaX;
                break;
            }
        }
        return result;
    }

    /** Finds nearest right changePoint to given and returns slope of the line, passing through given changePoint and found changePoint. */
    protected double returnEquationForRightDirection(int firstPointX) {
        double result = 0;

        for (int i = 0; i < changePointsX.length; i++) {
            if (changePointsX[i] > firstPointX) {
                double deltaY = changePointsY[i - 1] - changePointsY[i];
                double deltaX = changePointsX[i - 1] - changePointsX[i];

                result = deltaY / deltaX;
                break;
            }
        }
        return result;
    }
}
