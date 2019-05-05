package Vinnik.g144;

public class TripleChar {
    private char first;

    TripleChar(char symbol) {
        first = symbol;
    }

    public void triple(char symbol) {
        first = (char) (symbol + symbol + symbol);
    }
}
