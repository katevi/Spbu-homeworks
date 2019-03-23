package Vinnik.g144;

import java.io.IOException;
import java.util.Scanner;

/**Example of printing traversal of the array coil (snail).*/
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter length of array:");
        int length = input.nextInt();

        System.out.println("Enter array: ");
        int[][] array = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                array[i][j] = input.nextInt();
            }
        }

        System.out.println("Enter 1 if you want to print in console, 2 if you want to print in file:");
        int operation = input.nextInt();
        if (operation == 1) {
            Print output = new PrintToConsole();
            output.printSpiral(array);
        } else {
            Print output = new PrintToFile();
            output.printSpiral(array);
        }
    }
}