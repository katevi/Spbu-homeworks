package g144.Vinnik;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocalNetworkTest {

    @Test
    void showOneStepOfInfectionCase1() {
        LocalNetwork network = new LocalNetwork(3);

        network.addComputer("Windows");
        network.addComputer("Linux");
        network.addComputer("MacOS");

        network.setConnections(0, 1);
        network.setConnections(1, 2);

        SpecialRandom random = new SpecialRandom();
        Virus virus = new Virus(network, random, 1);


        assertEquals("Trying to infect computer number 0 with OS = Windows\n" +
                "Computer number 0 infected by computer number 1\n" +
                "Trying to infect computer number 2 with OS = MacOS\n" +
                "Computer number 2 infected by computer number 1\n", network.showOneStepOfInfection(virus));
        assertEquals("All computers infected.", network.showOneStepOfInfection(virus));
    }

    @Test
    void showOneStepOfInfectionCase2() {
        LocalNetwork network = new LocalNetwork(5);

        network.addComputer("Windows");
        network.addComputer("Linux");
        network.addComputer("MacOS");
        network.addComputer("MacOS");
        network.addComputer("Linux");

        network.setConnections(0, 1);
        network.setConnections(0, 2);
        network.setConnections(1, 4);
        network.setConnections(2, 3);
        network.setConnections(2, 4);
        network.setConnections(3, 4);

        SpecialRandom random = new SpecialRandom();
        Virus virus = new Virus(network, random, 2);


        assertEquals("Trying to infect computer number 0 with OS = Windows\n" +
                "Computer number 0 infected by computer number 2\n" +
                "Trying to infect computer number 3 with OS = MacOS\n" +
                "Computer number 3 infected by computer number 2\n" +
                "Trying to infect computer number 4 with OS = Linux\n" +
                "Computer number 4 infected by computer number 2\n", network.showOneStepOfInfection(virus));

        assertEquals("Trying to infect computer number 1 with OS = Linux\n" +
                "Computer number 1 infected by computer number 0\n", network.showOneStepOfInfection(virus));
        assertEquals("All computers infected.", network.showOneStepOfInfection(virus));
    }

    @Test
    void showInfectedComputers() {
        LocalNetwork network = new LocalNetwork(5);

        network.addComputer("Windows");
        network.addComputer("Linux");
        network.addComputer("MacOS");
        network.addComputer("MacOS");
        network.addComputer("Linux");

        network.setConnections(0, 1);
        network.setConnections(0, 2);
        network.setConnections(1, 4);
        network.setConnections(2, 3);
        network.setConnections(2, 4);
        network.setConnections(3, 4);

        SpecialRandom random = new SpecialRandom();
        Virus virus = new Virus(network, random, 3);

        assertEquals("Computer number 3 infected\n", network.showInfectedComputers(virus));
        network.showOneStepOfInfection(virus);
        assertEquals("Computer number 2 infected\n" +
                "Computer number 3 infected\n" +
                "Computer number 4 infected\n", network.showInfectedComputers(virus));
        network.showOneStepOfInfection(virus);
        assertEquals("Computer number 0 infected\n" +
                "Computer number 1 infected\n" +
                "Computer number 2 infected\n" +
                "Computer number 3 infected\n" +
                "Computer number 4 infected\n", network.showInfectedComputers(virus));
    }
}