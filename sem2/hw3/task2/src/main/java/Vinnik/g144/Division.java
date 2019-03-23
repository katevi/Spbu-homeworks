package Vinnik.g144;

public class Division extends Operator implements Operand {
    @Override
    public int calculate() {
        return left.calculate() / right.calculate();
    }

    /** When traversing the tree, returns this operand. */
    public Division() {
        operation = '/';
    }
}
