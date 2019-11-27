package g144.Vinnik;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;



/** Class for implementation of game part for client player. */
public class ClientGame implements Game {

    private Socket client;
    private PrintWriter output;
    private BufferedReader input;
    private String ipAddress;

    public static void main(String[] args) { }

    /** Assigns IP address of the server. */
    public ClientGame(String ipAddress) {
        this.ipAddress = ipAddress;
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
        System.out.println("Trying to connect");
        InetAddress inetAddress = null;
        if (client == null) {
            try {
                client = new Socket(inetAddress = InetAddress.getByName(ipAddress), ServerGame.PORT);
                output = new PrintWriter(client.getOutputStream());
                input = new BufferedReader(new InputStreamReader(client.getInputStream()));
            } catch (UnknownHostException e) {
                assert ipAddress != null;
                System.err.println("Don't know about host: " + inetAddress.getHostAddress());
                System.exit(1);
            } catch (IOException e) {
                System.err.println("Couldn't get I/O for the connection to: " + inetAddress.getHostAddress());
                System.exit(1);
            }
        }
    }
}