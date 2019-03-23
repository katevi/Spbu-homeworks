package Vinnik.g144;

public class Addition extends Operator implements Operand {

    @Override
    public int calculate() {
        return left.calculate() + right. calculate();
    }

    /** When traversing the tree, returns this operand. */
    public Addition() {
        operation = '+';
    }
}
