package g144.Vinnik;


import java.util.concurrent.ThreadLocalRandom;

/** Implements network virus. */
public class Virus {
    private int keyFirstInfected;
    private NetworkRandom random;


    /** Constructor with unpredictable number of first infected. */
    public Virus(LocalNetwork network, NetworkRandom newRandom) {
        keyFirstInfected = ThreadLocalRandom.current().nextInt(0, network.getCount());
        random = newRandom;
        network.getComputersKeys()[keyFirstInfected].setInfected(true);
    }

    /** Constructor with predictable number of first infected. (For tests). */
    public Virus(LocalNetwork network, NetworkRandom newRandom, int i) {
        keyFirstInfected = i;
        random = newRandom;
        network.getComputersKeys()[keyFirstInfected].setInfected(true);
    }

    private double getRandom() {
        return random.getRandom();
    }

    protected int getKeyFirstOfInfected() {
        return keyFirstInfected;
    }

    protected void tryToInfect(Computer computer) {
        double temp = getRandom();
        double probabilityInfection;
        switch (computer.getOS()) {
            case ("Windows"): {
                probabilityInfection = 0.3;
                break;
            }
            case ("Linux"): {
                probabilityInfection = 0.2;
                break;
            }
            case ("MacOS"): {
                probabilityInfection = 0.4;
                break;
            }
            default: {
                probabilityInfection = 0.5;
            }
        }
        if (temp < probabilityInfection) {
            computer.setInfected(true);
        }
    }
}
