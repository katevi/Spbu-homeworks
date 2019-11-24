package g144.Vinnik;

/** Interface for single objects interaction (server and client). */
public interface Game {
    void send(String command);
    String receive();
}
