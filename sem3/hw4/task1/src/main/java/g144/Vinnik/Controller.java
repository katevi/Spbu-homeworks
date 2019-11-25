package g144.Vinnik;

import g144.Vinnik.cannon.game.GamePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Controller extends JPanel {
    private JPanel contentPane;
    private JButton clientFieldButton;
    private JButton serverFieldButton;
    private JTextField textField;
    private JButton connectButton;
    private JLabel serverIP;

    private volatile Game game;

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Connection");
                Controller controller = new Controller();
                frame.setContentPane(controller.contentPane);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }


    private void serverFieldButtonPerformed(java.awt.event.ActionEvent e) {
        System.out.println("WE ARE HERE");
        clientFieldButton.setEnabled(false);
        InetAddress thisIp = null;
        try {
            thisIp = InetAddress.getLocalHost();
        } catch (UnknownHostException ex) {
            System.out.println("Can't get IP");
            System.exit(1);
        }

        serverIP.setText("Your IP address: " + thisIp.getHostAddress());
        serverIP.setVisible(true);
        serverFieldButton.setEnabled(false);
        gameForServer();
        disableConnectionMenu();
    }

    private void disableConnectionMenu() {
        Component[] components = contentPane.getComponents();
        for (int i = 0; i < components.length; i++) {
            components[i].setEnabled(false);
        }
    }

    private void gameForServer() {
        game = new ServerGame();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame gameFrame = new JFrame("Server");
                gameFrame.setResizable(false);
                gameFrame.add(new GamePanel());
                gameFrame.pack();
                gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                gameFrame.setLocationRelativeTo(null);
                gameFrame.setVisible(true);
            }
        });
    }

    private void clientFieldButtonPerformed(java.awt.event.ActionEvent e) {

    }


    private void createUIComponents() {
        contentPane = new JPanel();
        serverFieldButton = new JButton();
        clientFieldButton = new JButton();


        serverFieldButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                serverFieldButtonPerformed(e);
            }
        });

        clientFieldButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clientFieldButtonPerformed(e);
            }
        });
    }
}
