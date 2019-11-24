package g144.Vinnik;

import g144.Vinnik.cannon.game.GamePanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Controller extends JDialog {
    private JPanel contentPane;
    private JButton clientFieldButton;
    private JButton serverFieldButton;
    private JTextField textField1;
    private JButton connectButton;
    private JLabel serverIP;
    private JButton buttonOK;
    private JButton buttonCancel;


    public Controller() {
        setContentPane(contentPane);
        setModal(true);
        serverIP.setVisible(false);
    }

    public static void main(String[] args) {
        Controller dialog = new Controller();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
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

        //FIXME
        JFrame gameFrame = new JFrame("Server");
        gameFrame.setResizable(false);
        gameFrame.add(new GamePanel());
        gameFrame.pack();
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setLocationRelativeTo(null);
        gameFrame.setVisible(true);
    }

    private void clientFieldButtonPerformed(java.awt.event.ActionEvent e) {

    }

    private void createUIComponents() {
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
