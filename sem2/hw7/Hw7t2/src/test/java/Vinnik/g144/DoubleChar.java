package Vinnik.g144;

public class DoubleChar {
    private char first;

    DoubleChar(char symbol) {
        first = symbol;
    }

    public void doubleChar(char symbol) {
        first = (char) (symbol + symbol);
    }
}
