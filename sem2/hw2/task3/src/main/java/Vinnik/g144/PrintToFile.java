package Vinnik.g144;

import java.io.*;

/** Prints traversal of array coil to file. */
public class PrintToFile implements Print {
    @Override
    public void printSpiral(int[][] originalArray) throws FileNotFoundException {
        PrintStream printToFile = new PrintStream("output.txt");
        Spiral.countResultArray(originalArray, printToFile);
    }
}