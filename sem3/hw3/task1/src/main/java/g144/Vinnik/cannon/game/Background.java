package g144.Vinnik.cannon.game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Background extends Sprite {
    private final Image image;

    public Background(int newX, int newY, int newSpeed) {
        super(newX, newY, newSpeed);
        this.image = new ImageIcon(getClass().getResource("/land.jpg")).getImage();
    }

    @Override
    protected void draw(Graphics2D graphics2D) {
        graphics2D.drawImage(this.image, getX(), getY(), null);
    }
}
