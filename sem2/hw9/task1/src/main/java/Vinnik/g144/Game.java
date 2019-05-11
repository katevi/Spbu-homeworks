package Vinnik.g144;

/** Interface for single objects interaction (server and client). */
public interface Game {
    void send(String command);
    String receive();
}
