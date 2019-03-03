package Vinnik.g144;

//import static jdk.nashorn.internal.objects.NativeArray.reverse;

public class Spiral {
    public static int[] resultArray(int[][] originalArray) {
        int originalLength = originalArray.length;
        int[] resultArray = new int[originalLength * originalLength];
        int currentIndex = 0;
        for (int i = 0; i < originalLength / 2; i++) {
            for (int j = i; j < originalLength - i - 1; j++) {
                resultArray[currentIndex] = originalArray[i][j];
                currentIndex++;
            }
            for (int j = i; j < originalLength - i - 1; j++) {
                resultArray[currentIndex] = originalArray[j][originalLength - i - 1];
                currentIndex++;
            }
            for (int j = i; j < originalLength - i - 1; j++) {
                resultArray[currentIndex] = originalArray[originalLength - i - 1][originalLength - j - 1];
                currentIndex++;
            }
            for (int j = i; j < originalLength - i - 1; j++) {
                resultArray[currentIndex] = originalArray[originalLength - j - 1][i];
                currentIndex++;
            }
        }
        resultArray[currentIndex] = originalArray[originalLength / 2][originalLength / 2];
        resultArray = reverse(resultArray);

        return resultArray;
    }

    private static int[] reverse(int[] originalArray) {
        int[] reverseArray = new int[originalArray.length];
        for (int i = 0; i < originalArray.length; i++) {
            reverseArray[i] = originalArray[originalArray.length - 1 - i];
        }
        return reverseArray;
    }
}