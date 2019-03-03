package Vinnik.g144;

import java.io.PrintWriter;
import java.io.*;

public class PrintToFile implements Print {
    @Override
    public int[] printSpiral(int[][] originalArray) throws FileNotFoundException {
        Spiral spiral = new Spiral();
        int[] resultArray = spiral.resultArray(originalArray);

        PrintWriter out = new PrintWriter(new File("output.txt"));
        for (int i = 0; i < resultArray.length; i++) {
            out.write(resultArray[i] + " ");
        }
        out.close();

        return resultArray;
    }
}