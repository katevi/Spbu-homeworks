package Vinnik.g144;

/** Implements simple single-threaded quick sort, which sorts integer numbers. */
public class QuickSort implements Sorter {

    /**
     * Sorts array with integer numbers.
     *
     * @param numbers - array of integer numbers.
     */
    @Override
    public void sort(int[] numbers) {
        quickSort(numbers, 0, numbers.length - 1);
    }

    private void quickSort(int[] numbers, int first, int last) {
        if (numbers.length == 0)
            return;

        if (first >= last)
            return;

        int middle = first + (last - first) / 2;
        int pivot = numbers[middle];

        int i = first, j = last;
        while (i <= j) {
            while (numbers[i] < pivot) {
                i++;
            }

            while (numbers[j] > pivot) {
                j--;
            }

            if (i <= j) {
                int temp = numbers[i];
                numbers[i] = numbers[j];
                numbers[j] = temp;
                i++;
                j--;
            }
        }

        if (first < j)
            quickSort(numbers, first, j);

        if (last > i)
            quickSort(numbers, i, last);
    }
}