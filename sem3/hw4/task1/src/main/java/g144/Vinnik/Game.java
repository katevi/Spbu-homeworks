package g144.Vinnik;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/** Interface for single objects interaction (server and client). */
public abstract class Game implements AutoCloseable {
    volatile PrintWriter out;
    volatile BufferedReader in;
    private final ExecutorService sender = Executors.newSingleThreadExecutor();

    /**
     * sends command
     * @param command your List from commands
     */
    public void send(Integer command) {
        /*if (commands.isEmpty()) {
            out.println(0);
            return;
        }*/
        //LinkedList<Integer> commandsToSend = LinkedList.copyOf(commands);
        /*sender.submit(() -> {
            System.out.println("Sending commands");
            init();
            for (int i = 0; i < commands.size(); i++) {
                out.println(commands.get(i));
            }
            out.flush();
        });*/
        out.println(command);
        out.flush();
    }


    public Integer receive() {
        initUnderLock();

        return in.lines()
                .limit(1)
                .findAny()
                .map(Integer::valueOf)
                .orElse(0);

    }

    /**
     * Method for correct initUnderLock()
     */
    private void init() {
        if (in == null) {
            synchronized (this) {
                initUnderLock();
            }
        }
    }

    /** initialization **/
    protected abstract void initUnderLock();

    @Override
    public void close() {
        try {
            out.close();
            in.close();
            sender.shutdown();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
