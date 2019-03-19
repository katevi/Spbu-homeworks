package g144.Vinnik;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BubbleSortTest {

    @Test
    void sortUnsortedNumbers() {
        int numbersToSort[] = {1, 3, 2, 5, 5, 6, 9, 8, 7, 4};
        int numbersResult[] = {1, 2, 3, 4, 5, 5, 6, 7, 8, 9};
        Sorter sampleBubbleSort = new BubbleSort();
        sampleBubbleSort.sort(numbersToSort);
        assertArrayEquals(numbersResult, numbersToSort);
    }

    @Test
    void sortSameNumbers() {
        int numbersToSort[] = {42};
        int numbersResult[] = {42};
        Sorter sampleBubbleSort = new BubbleSort();
        sampleBubbleSort.sort(numbersToSort);
        assertArrayEquals(numbersResult, numbersToSort);
    }

    @Test
    void sortSortedNumbers() {
        int numbersToSort[] = {0, 7, 8, 9, 10};
        int numbersResult[] = {0, 7, 8, 9, 10};
        Sorter sampleBubbleSort = new BubbleSort();
        sampleBubbleSort.sort(numbersToSort);
        assertArrayEquals(numbersResult, numbersToSort);
    }
}