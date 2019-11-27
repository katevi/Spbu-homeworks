package g144.Vinnik;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public abstract class Canvas extends JPanel implements KeyListener {

    public Canvas() {
        this.addKeyListener(Canvas.this);
        setDoubleBuffered(true);
        setFocusable(true);
        requestFocus();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        onDraw(g2D);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        onKeyUp(e);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        onKeyPressed(e);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    protected abstract void onKeyUp(KeyEvent e);
    protected abstract void onKeyPressed(KeyEvent e);
    protected abstract void onDraw(Graphics2D graphics2D);
}
