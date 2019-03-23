package Vinnik.g144;

public class Multiplication extends Operator implements Operand {
    @Override
    public int calculate() {
        return left.calculate() * right.calculate();
    }

    /** When traversing the tree, returns this operand. */
    public Multiplication() {
        operation = '*';
    }
}
