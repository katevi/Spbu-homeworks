package g144.Vinnik;


public class LocalNetwork {
    private boolean[][] matrix;
    private Computer[] computers;
    private int countOfAddedComputers;
    private boolean[] infectedComputersInCurrentStep;

    /** Creates local network with given number of computers. */
    public LocalNetwork(int n) {
        matrix = new boolean[n][n];
        computers = new Computer[n];
        infectedComputersInCurrentStep = new boolean[n];
        countOfAddedComputers = 0;
    }

    /** Adds computer with given OS to current network. */
    public void addComputer(String nameOS) {
        if (countOfAddedComputers <= matrix.length) {
            matrix[countOfAddedComputers][countOfAddedComputers] = true;
            computers[countOfAddedComputers] = new Computer(nameOS);
            countOfAddedComputers++;
        }
    }

    protected int getCount() {
        return countOfAddedComputers;
    }

    protected Computer[] getComputersKeys() {
        return computers;
    }

    /** Adds connection between two computers to adjacency matrix. */
    public void setConnections(int i, int j) {
        matrix[i][j] = true;
        matrix[j][i] = true;
    }

    private boolean allInfected() {
        boolean result = true;
        for (Computer i : computers) {
            result = result && i.isInfected();
            if (!result) {
                return false;
            }
        }
        return true;
    }

    private void updateInfected() {
        for (int i = 0; i < infectedComputersInCurrentStep.length; i++) {
            if (computers[i].isInfected()) {
                infectedComputersInCurrentStep[i] = true;
            }
        }
    }

    /** Shows one pass in infected computers set: each infect computer from set tries to infect not infected computers. */
    public String showOneStepOfInfection(Virus virus) {
        StringBuilder output = new StringBuilder();
        infectedComputersInCurrentStep[virus.getKeyFirstOfInfected()] = true;
        if (!allInfected()) {
            for (int i = 0; i < countOfAddedComputers; i++) {
                if (infectedComputersInCurrentStep[i]) {
                    for (int j = 0; j < countOfAddedComputers; j++) {
                        if (j != i && matrix[i][j] == true && !infectedComputersInCurrentStep[j] && !computers[j].isInfected()) {

                            output.append("Trying to infect computer number ");
                            output.append(j);
                            output.append(" with OS = ");
                            output.append(computers[j].getOS());
                            output.append("\n");

                            virus.tryToInfect(computers[j]);
                            if (computers[j].isInfected()) {
                                output.append("Computer number ");
                                output.append(j);
                                output.append(" infected by computer number ");
                                output.append(i);
                                output.append("\n");
                            } else {
                                output.append("Computer number ");
                                output.append(j);
                                output.append(" not infected");
                                output.append("\n");
                            }
                        }
                    }
                }
            }
            updateInfected();
        } else {
            output.append("All computers infected.");
        }
        return output.toString();
    }

    /** Shows which computers already infected. */
    public String showInfectedComputers(Virus virus) {
        infectedComputersInCurrentStep[virus.getKeyFirstOfInfected()] = true;
        String result = "";
        for (int i = 0; i < infectedComputersInCurrentStep.length; i++) {
            if (infectedComputersInCurrentStep[i]) {
                result += "Computer number " + i + " infected\n";
            }
        }
        return result;
    }

    /** Shows infection steps, until all computers are not infected. */
    public void startInfection(Virus virus) {
        System.out.println("First infected is " + virus.getKeyFirstOfInfected());
        infectedComputersInCurrentStep[virus.getKeyFirstOfInfected()] = true;
        System.out.println("Start infection...");
        int count = 0;
        while (!allInfected()) {
            if (count > 0) {
                System.out.println("The next step of infection...");
            }
            count++;
            for (int i = 0; i < countOfAddedComputers; i++) {
                if (infectedComputersInCurrentStep[i]) {
                    for (int j = 0; j < countOfAddedComputers; j++) {
                        if (j != i && matrix[i][j] == true && !infectedComputersInCurrentStep[j] && !computers[j].isInfected()) {
                            System.out.println("Trying to infect computer number " + j + " with OS = " + computers[j].getOS());
                            virus.tryToInfect(computers[j]);
                            if (computers[j].isInfected()) {
                                System.out.println("Computer number" + j + " infected by computer number " + i + "\n");
                            } else {
                                System.out.println("Computer number" + j + " not infected" + "\n");
                            }
                        }
                    }
                }
            }
            updateInfected();
        }
        System.out.println("Infection completed with " + count + " steps.");
    }
}
