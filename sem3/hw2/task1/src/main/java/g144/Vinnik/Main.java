package g144.Vinnik;

import java.util.Scanner;

/** Implements user conversation with example of network work.
 * Full example of input data:
 *
 * 5
 *
 * Windows
 * Linux
 * MacOS
 * Linux
 * Windows
 *
 * 6
 *
 * 0 1
 * 0 2
 * 1 2
 * 1 3
 * 2 4
 * 3 4 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of computers. After press button Enter. ");
        int numberOfComputers = scanner.nextInt();
        while (numberOfComputers <= 0) {
            System.out.println("Enter positive number");
            numberOfComputers = scanner.nextInt();
        }
        LocalNetwork network = new LocalNetwork(numberOfComputers);

        System.out.println("Enter computers OS: Windows/Linux/MacOS. After each name press button Enter.");
        for (int k = 0; k < numberOfComputers; k++) {
            String nameOS = scanner.next();
            network.addComputer(nameOS);
        }

        System.out.println("Enter number of computer connections. After press button Enter.");
        int numberConnections = scanner.nextInt();

        while (numberConnections <= 0) {
            System.out.println("Enter positive number");
            numberConnections = scanner.nextInt();
        }

        System.out.println("Enter computer connections with a space. Example: 0 1 (computer0 connected with computer1). After press button Enter.");
        for (int k = 0; k < numberConnections; k++) {
            int i = scanner.nextInt();
            int j = scanner.nextInt();
            network.setConnections(i, j);
        }

        SimpleRandom random = new SimpleRandom();
        Virus virus = new Virus(network, random);
        network.startInfection(virus);
    }
}
