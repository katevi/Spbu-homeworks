package Vinnik.g144;

import java.io.PrintStream;

/**Prints traversal of array coil to console. */
class PrintToConsole implements Print {
    @Override
    public void printSpiral(int[][] originalArray) {
        PrintStream printToConsole = new PrintStream(System.out);
        Spiral.countResultArray(originalArray, printToConsole);
    }
}