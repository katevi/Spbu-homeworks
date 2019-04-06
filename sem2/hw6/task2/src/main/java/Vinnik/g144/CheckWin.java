package Vinnik.g144;

/** Checks if there is a sequence of three consecutive zeros or crosses in the table*/
public class CheckWin {
    private boolean isThreeInRow(String[][] values, int indexRow) {
        return (values[0][indexRow].equals(values[1][indexRow]))
                && (values[1][indexRow].equals(values[2][indexRow]))
                && (!values[0][indexRow].equals(""));
    }

    private boolean isThreeInColumn(String[][] values, int indexOfColumn) {
        return  (values[indexOfColumn][0].equals(values[indexOfColumn][1]))
                && (values[indexOfColumn][1].equals(values[indexOfColumn][2]))
                && (!values[indexOfColumn][0].equals(""));
    }

    private boolean isThreeInFirstDiagonal(String[][] values) {
        return (values[1][1].equals(values[2][2]) && values[2][2].equals(values[0][0])
                && !values[1][1].equals("") && !values[2][2].equals("") && !values[0][0].equals(""));
    }

    private boolean isThreeInSecondDiagonal(String[][] values) {
        return (values[2][0].equals(values[1][1]) && values[1][1].equals(values[0][2])
                && !values[2][0].equals("") && !values[1][1].equals("") && !values[0][2].equals(""));
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
