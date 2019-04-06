package Vinnik.g144;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckWinTest {

    @Test
    void isWinInFirstDiagonalTest() {
        String[][] values = new String[3][3];
        values[0][0] = "O";
        values[0][1] = "X";
        values[0][2] = "X";
        values[1][0] = "X";
        values[1][1] = "O";
        values[1][2] = "O";
        values[2][0] = "O";
        values[2][1] = "O";
        values[2][2] = "O";
        CheckWin checkWin = new CheckWin();
        assertTrue(checkWin.isWin(values));
    }

    @Test
    void isWinInSecondDiagonalTest() {
        String[][] values = new String[3][3];
        values[0][0] = "X";
        values[0][1] = "X";
        values[0][2] = "O";
        values[1][0] = "X";
        values[1][1] = "O";
        values[1][2] = "O";
        values[2][0] = "O";
        values[2][1] = "O";
        values[2][2] = "O";
        CheckWin checkWin = new CheckWin();
        assertTrue(checkWin.isWin(values));
    }

    @Test
    void isWinInRowTest() {
        String[][] values = new String[3][3];
        values[0][0] = "O";
        values[0][1] = "O";
        values[0][2] = "O";
        values[1][0] = "X";
        values[1][1] = "O";
        values[1][2] = "X";
        values[2][0] = "O";
        values[2][1] = "X";
        values[2][2] = "O";
        CheckWin checkWin = new CheckWin();
        assertTrue(checkWin.isWin(values));
    }

    @Test
    void isWinInColumnTest() {
        String[][] values = new String[3][3];
        values[0][0] = "X";
        values[0][1] = "O";
        values[0][2] = "O";
        values[1][0] = "X";
        values[1][1] = "O";
        values[1][2] = "X";
        values[2][0] = "O";
        values[2][1] = "O";
        values[2][2] = "X";
        CheckWin checkWin = new CheckWin();
        assertTrue(checkWin.isWin(values));
    }
}