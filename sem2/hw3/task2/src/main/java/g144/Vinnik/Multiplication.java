package g144.Vinnik;

/** Class, responsible for the two numbers multiplication. */
public class Multiplication extends Operator implements Operand {

    @Override
    /** Multiplies a left leaf number with right. */
    public int calculate() {
        return left.calculate() * right.calculate();
    }

    /** When traversing the tree, returns this operand. */
    public Multiplication() {
        operation = '*';
    }
}
