package g144.Vinnik;

/** Class, responsible for the two numbers addition. */
public class Addition extends Operator implements Operand {

    @Override
    /** Sums numbers from leafs. */
    public int calculate() {
        return left.calculate() + right. calculate();
    }

    /** When traversing the tree, returns this operand. */
    public Addition() {
        operation = '+';
    }
}
