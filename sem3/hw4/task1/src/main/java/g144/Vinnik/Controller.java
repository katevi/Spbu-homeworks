package g144.Vinnik;

import g144.Vinnik.cannon.game.GamePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Controller extends JPanel {
    private JPanel contentPane;
    private JButton clientFieldButton;
    private JButton serverFieldButton;
    private JTextField enteredIpAddress;
    private JButton connectButton;
    private JLabel serverIP;

    private volatile Game game;

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Connection");
                Controller controller = new Controller();
                frame.setResizable(false);
                frame.setContentPane(controller.contentPane);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }

    private void disableConnectionMenu() {
        Component[] components = contentPane.getComponents();
        for (int i = 0; i < components.length; i++) {
            components[i].setEnabled(false);
        }
    }

    private void serverFieldButtonPerformed(java.awt.event.ActionEvent e) {
        System.out.println("WE ARE HERE");
        clientFieldButton.setEnabled(false);
        InetAddress thisIp = null;
        try {
            thisIp = InetAddress.getLocalHost();
        } catch (UnknownHostException ex) {
            JOptionPane.showMessageDialog(contentPane, "Can't get IP");
            System.exit(1);
        }

        serverIP.setText("Your IP address: " + thisIp.getHostAddress());
        serverIP.setVisible(true);
        serverFieldButton.setEnabled(false);
        gameForServer();
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

    private void connectFieldButtonPerformed(java.awt.event.ActionEvent event) {
        String ipAddressText = enteredIpAddress.getText();

        try {
            if (!InetAddress.getLocalHost().getHostAddress().equals(ipAddressText)) {
                JOptionPane.showMessageDialog(contentPane, "Wrong IP", "Error", JOptionPane.WARNING_MESSAGE);
                System.exit(1);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(contentPane, "Couldn't get I/O for the connection to: " + ipAddressText, "Error", JOptionPane.WARNING_MESSAGE);
            System.exit(1);
        }
        connectButton.setEnabled(false);
        enteredIpAddress.setEnabled(false);
        gameForClient(ipAddressText);
    }

    private void gameForClient(String ipAddress) {
        game = new ClientGame(ipAddress);
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame gameFrame = new JFrame("Client");
                gameFrame.setResizable(false);
                gameFrame.add(new GamePanel());
                gameFrame.pack();
                gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                gameFrame.setLocationRelativeTo(null);
                gameFrame.setVisible(true);
            }
        });
    }


    private void createUIComponents() {
        contentPane = new JPanel();
        serverFieldButton = new JButton();
        clientFieldButton = new JButton();
        connectButton = new JButton();
        enteredIpAddress = new JTextField();
        serverIP = new JLabel();

        serverFieldButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                serverFieldButtonPerformed(e);
                disableConnectionMenu();
            }
        });
        clientFieldButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Clicked on clientButton");
                serverFieldButton.setEnabled(false);
            }
        });
        connectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Clicked on connect button");
                connectFieldButtonPerformed(e);
                disableConnectionMenu();
            }
        });
    }
}
