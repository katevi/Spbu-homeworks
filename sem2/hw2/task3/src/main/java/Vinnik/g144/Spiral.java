package Vinnik.g144;

import java.io.PrintStream;

/**Implementation of traversal of the array coil. */
public class Spiral {
    public static void countResultArray(int[][] originalArray, PrintStream stream) {
        int size = originalArray.length;

        int left = (size - 1) / 2;
        int right = left;

        int i = left;
        int j = left;

        for (int k = 0; k < size * size; k++) {
            stream.print(originalArray[i][j] + " ");
            if ((j == left) && (i == left)) {
                right++;
                left--;
                j--;
            } else if ((j == left) && (i < right)) {
                i++;
            } else if ((j < right) && (i == right)) {
                j++;
            } else if ((j == right) && (i > left)) {
                i--;
            } else if ((j > left) && (i == left)) {
                j--;
            }
        }

    }
}