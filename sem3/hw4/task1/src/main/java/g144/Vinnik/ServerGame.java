package g144.Vinnik;


import javax.swing.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


/** Class for implementation of game part for server player. */
public class ServerGame extends Game {

    public static final int PORT = 12345;
    private ServerSocket server;
    private Socket client;

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
    protected void initUnderLock() {
        if (client == null) {
            try {
                client = server.accept();
                in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                out = new PrintWriter(client.getOutputStream());
            } catch (IOException e) {
                System.out.println("Exception");
                throw new UncheckedIOException(e);
            }
        }
    }
}
