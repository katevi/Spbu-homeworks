package g144.Vinnik;

import g144.Vinnik.cannon.game.GamePanel;

import javax.swing.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


/** Class for implementation of game part for server player. */
public class ServerGame implements Game {

    public static final int PORT = 12345;
    private ServerSocket server;
    private Socket client;
    private BufferedReader input;
    private PrintWriter output;

    public static void main(String[] args) {
    }


    /** Raises the server with the specified port. */
    public ServerGame() {
        try {
            server = new ServerSocket(PORT);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "Error, the server is already running",
                    "Error",
                    JOptionPane.WARNING_MESSAGE);
            System.exit(1);
        }
    }

    @Override
    /**
     * Sends given command.
     * @param command your command
     */
    public synchronized void send(String command) {
        init();

        output.println(command);
        output.flush();

    }

    @Override
    /** Returns received command. */
    public String receive() {
        init();
        return input.lines().limit(1).findAny().orElse(null);
    }

    private void init() {
        if (client == null) {
            try {
                client = server.accept();
                input = new BufferedReader(new InputStreamReader(client.getInputStream()));
                output = new PrintWriter(client.getOutputStream());
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
        }
    }
}
