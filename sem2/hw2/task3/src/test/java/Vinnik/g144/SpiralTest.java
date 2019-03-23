package Vinnik.g144;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class SpiralTest {

    @Test
    void resultArrayTest() {
        int[] result = {5, 4, 7, 8, 9, 6, 3, 2, 1};
        int[][] array = new int[3][3];
        int count = 1;
        Spiral spiral = new Spiral();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                array[i][j] = count;
                count++;
            }
        }
        for (int i = 0; i < result.length; i++) {
            assertEquals(result[i], (spiral.resultArray(array))[i]);
        }
    }
}