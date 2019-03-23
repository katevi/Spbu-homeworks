package Vinnik.g144;

/** Number operand class. */
public class Number implements Operand {
    private int number;

    public Number(int number) {
        this.number = number;
    }

    /** When traversing the tree, returns this operand. */
    @Override
    public String output() {
        return Integer.toString(number);
    }

    @Override
    public int calculate() {
        return number;
    }
}
