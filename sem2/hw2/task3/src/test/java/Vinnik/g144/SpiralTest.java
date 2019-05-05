package Vinnik.g144;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;


class SpiralTest {

    @Test
    void resultArrayTest() {
        ByteArrayOutputStream streamToCheck = new ByteArrayOutputStream();
        String resultArray = "5 4 7 8 9 6 3 2 1 ";
        System.setOut(new PrintStream(streamToCheck));

        int[][] array = new int[3][3];
        int count = 1;
        Spiral spiral = new Spiral();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                array[i][j] = count;
                count++;
            }
        }

        spiral.countResultArray(array, System.out);
        assertEquals(resultArray, streamToCheck.toString());
    }

    @Test
    void resultRandomArrayTest() {
        ByteArrayOutputStream streamToCheck = new ByteArrayOutputStream();
        String resultArray = "1 6 11 22 0 7 8 4 2 ";
        System.setOut(new PrintStream(streamToCheck));

        Spiral spiral = new Spiral();
        int[][] array = {{2, 4, 8}, {6, 1, 7}, {11, 22, 0}};

        spiral.countResultArray(array, System.out);
        assertEquals(resultArray, streamToCheck.toString());
    }
}