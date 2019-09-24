package Vinnik.g144;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MultithreadedQuickSortTest {

    Sorter sorter = new MultithreadedQuickSort();

    @Test
    void multithreadedQuickSortWhenArraySortedTest() {
        int[] expected = new int[100];
        int[] result = new int[100];
        for (int i = 0; i < expected.length; i++) {
            expected[i] = i;
            result[i] = i;
        }
        sorter.sort(result);
        assertArrayEquals(expected, result);
    }

    @Test
    void multithreadedQuickSortWhenTheSameNumbersTest() {
        int[] expected = new int[100];
        int[] result = new int[100];
        for (int i = 0; i < expected.length; i++) {
            expected[i] = 132;
            result[i] = 132;
        }
        sorter.sort(result);
        assertArrayEquals(expected, result);
    }

    @Test
    void multithreadedQuickSortTest() {
        int[] result = new int[] {1, 3, 5, 9, 113, -8, 0, -7, -7, -25};
        int[] expected = new int[] {-25, -8, -7, -7, 0, 1, 3, 5, 9, 113};
        sorter.sort(result);
        assertArrayEquals(expected, result);
    }

    @Test
    void multithreadedQuickSortEmpty() {
        int[] result = {};
        int[] expected = {};
        sorter.sort(result);
        assertArrayEquals(expected, result);
    }
}