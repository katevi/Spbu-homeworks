package g144.Vinnik;

/** Implements simple SelectionSort**/
public class SelectionSort implements Sorter {
    @Override
    public void sort(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            int first = numbers[i];
            int minimum = i;
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[j] < first) {
                    first = numbers[j];
                    minimum = j;
                }
            }
            if (i != minimum) {
                int temp = numbers[i];
                numbers[i] = numbers[minimum];
                numbers[minimum] = temp;
            }
        }
    }
}
