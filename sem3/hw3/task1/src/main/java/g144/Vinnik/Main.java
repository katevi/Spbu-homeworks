package g144.Vinnik;

import g144.Vinnik.cannon.game.GamePanel;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame gameFrame = new JFrame("Cannon");
                gameFrame.setResizable(false);
                gameFrame.add(new GamePanel());
                gameFrame.pack();
                gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                gameFrame.setLocationRelativeTo(null);
                //gameFrame.setSize(450, 650);
                gameFrame.setVisible(true);
            }
        });

    }
}
