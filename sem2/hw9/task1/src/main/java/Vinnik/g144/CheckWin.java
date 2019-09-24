package Vinnik.g144;

/** Checks if there is a sequence of three consecutive zeros or crosses in the table*/
public class CheckWin {
    /** In a given two-dimensional array finds three identical in a row (column, diagonal) standing element.
     *
     * @param values - two-dimensional array.
     * @return - true, if there are three in a row, false otherwise.
     */
    public static boolean isWinner(String[][] values) {
        boolean isWin = false;

        for (int i = 0; i < 3; i++) {
            isWin = isWin || isThreeInColumn(values, i);
        }

        for (int i = 0; i < 3; i++) {
            isWin = isWin || isThreeInRow(values, i);
        }

        return isWin || isThreeInFirstDiagonal(values) || isThreeInSecondDiagonal(values);
    }

    private static boolean isThreeInRow(String[][] values, int indexRow) {
        boolean result = true;
        for (int i = 1; i < values.length; i++) {
            result = result && values[i][indexRow].equals(values[i - 1][indexRow])
                    && (!values[i][indexRow].equals(""));
        }
        return result;
    }

    private static boolean isThreeInColumn(String[][] values, int indexOfColumn) {
        boolean result = true;
        for (int i = 1; i < values.length; i++) {
            result = result && values[indexOfColumn][i].equals(values[indexOfColumn][i - 1])
                    && (!values[indexOfColumn][i].equals(""));
        }
        return result;
    }

    private static boolean isThreeInFirstDiagonal(String[][] values) {
        boolean result = true;
        for (int i = 1; i < values.length; i++) {
            result = result && values[i][i].equals(values[i - 1][i - 1])
                    && (!values[i][i].equals(""));
        }
        return result;
    }

    private static boolean isThreeInSecondDiagonal(String[][] values) {
        boolean result = true;
        for (int i = 1; i < values.length; i++) {
            result = result && values[i][values.length - 1 - i].equals(values[i - 1][values.length - i])
                    && (!values[i][values.length - 1 - i].equals(""));
        }
        return result;
    }
}
