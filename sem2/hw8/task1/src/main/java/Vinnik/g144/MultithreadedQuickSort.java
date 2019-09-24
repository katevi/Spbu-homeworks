package Vinnik.g144;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/** Implements multithreaded quick sort (with simple implementation of sort). */
public class MultithreadedQuickSort implements Sorter {

    /**
     * Sorts array with integer numbers.
     *
     * @param numbers - array of integer numbers.
     */
    @Override
    public void sort(int[] numbers) {
        ForkJoinPool.commonPool().invoke(new SortAction(numbers, 0, numbers.length - 1));
    }

    private class SortAction extends RecursiveAction {

        private int[] numbers;
        private int left;
        private int right;

        SortAction(int[] array, int first, int last) {
            this.numbers = array;
            this.left = first;
            this.right = last;
        }

        @Override
        protected void compute() {
            if (left >= right)
                return;

            if (numbers.length == 0) {
                return;
            }

            int middle = left + (right - left) / 2;
            int pivot = numbers[middle];

            int i = left, j = right;
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

            invokeAll(new SortAction(numbers, left, i - 1), new SortAction(numbers, i, right));
        }

    }
}

