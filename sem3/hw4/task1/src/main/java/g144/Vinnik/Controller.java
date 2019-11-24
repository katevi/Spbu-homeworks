package g144.Vinnik;

import javax.swing.*;
import java.awt.event.*;

public class Controller extends JDialog {
    private JPanel contentPane;
    private JButton clientFieldButton;
    private JButton serverFieldButton;
    private JTextField textField1;
    private JButton connectButton;
    private JButton buttonOK;
    private JButton buttonCancel;

    public Controller() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

    }

    public static void main(String[] args) {
        Controller dialog = new Controller();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
