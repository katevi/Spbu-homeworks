package Vinnik.g144;

import java.util.Random;

/** Class, which illustrates time difference between sort array through simple quick sort
 *  and through multithreaded quick sort, print results to the console. */
public class Main {
    private static final int AMOUNT_OF_TESTS = 10;
    private static final int SIZE_OF_ARRAY = 10000000;

    public static void main(String[] args) {

        double sumTimeSinglehreadedQuickort = 0;
        double sumTimeMultithreadedQuicksort = 0;

        for (int i = 0; i < AMOUNT_OF_TESTS; i++) {
            int[] numbersForSinglethreadedSort = generateRandomArray();
            int[] numbersForMultithreadedSort = numbersForSinglethreadedSort.clone();

            Sorter sortForSinglethreaded = new QuickSort();
            double currentTimeSinglethreadedQuicksort = getTime(numbersForSinglethreadedSort, sortForSinglethreaded);

            Sorter sortForMultithreaded = new MultithreadedQuickSort();
            double currentTimeMultithreadedQuicksort = getTime(numbersForMultithreadedSort, sortForMultithreaded);

            System.out.print(currentTimeMultithreadedQuicksort + " " + currentTimeSinglethreadedQuicksort + "\n");

            sumTimeSinglehreadedQuickort += currentTimeSinglethreadedQuicksort;
            sumTimeMultithreadedQuicksort += currentTimeMultithreadedQuicksort;
        }
        System.out.println("10 tests with arrays of dimension 1000 were performed. ");
        System.out.println("Average = (the total duration of each test) / (number of tests). ");
        System.out.println("Singlethreaded quick sort: " + sumTimeSinglehreadedQuickort / AMOUNT_OF_TESTS);
        System.out.println("Multithreaded quick sort: " + sumTimeMultithreadedQuicksort / AMOUNT_OF_TESTS);
    }

    private static double getTime(int[] array, Sorter sorter) {
        long startTime = System.currentTimeMillis();
        sorter.sort(array);
        long finishTime = System.currentTimeMillis();
        return (double) (finishTime - startTime);
    }

    private static int[] generateRandomArray() {
        int[] array = new int[SIZE_OF_ARRAY];
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());
        for (int i = 0; i < SIZE_OF_ARRAY; i++) {
            array[i] = random.nextInt();
        }
        return array;
    }
}
