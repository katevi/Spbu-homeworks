package Vinnik.g144;

/** Checks if there is a sequence of three consecutive zeros or crosses in the table*/
public class CheckWin {
    private boolean isThreeInRow(String[][] values, int indexRow) {
        boolean result = true;
        for (int i = 1; i < values.length; i++) {
            result = result && values[i][indexRow].equals(values[i - 1][indexRow])
                    && (!values[i][indexRow].equals(""));
        }
        return result;
    }

    private boolean isThreeInColumn(String[][] values, int indexOfColumn) {
        boolean result = true;
        for (int i = 1; i < values.length; i++) {
            result = result && values[indexOfColumn][i].equals(values[indexOfColumn][i - 1])
                    && (!values[indexOfColumn][i].equals(""));
        }
        return result;
    }

    private boolean isThreeInFirstDiagonal(String[][] values) {
        boolean result = true;
        for (int i = 1; i < values.length; i++) {
            result = result && values[i][i].equals(values[i - 1][i - 1])
                    && (!values[i][i].equals(""));
        }
        return result;
    }

    private boolean isThreeInSecondDiagonal(String[][] values) {
        boolean result = true;
        for (int i = 1; i < values.length; i++) {
            result = result && values[i][values.length - 1 - i].equals(values[i - 1][values.length - i])
                    && (!values[i][values.length - 1 - i].equals(""));
        }
        return result;
    }

    public boolean isWin(String[][] values) {
        boolean isWin = false;
        for (int i = 0; i < 3; i++) {
            isWin = isWin || isThreeInColumn(values, i);
        }

        for (int i = 0; i < 3; i++) {
            isWin = isWin || isThreeInRow(values, i);
        }
        return isWin || isThreeInFirstDiagonal(values) || isThreeInSecondDiagonal(values);
    }
}
