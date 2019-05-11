package g144.Vinnik;

/** Class, responsible for the two numbers subtraction. */
public class Subtraction extends Operator implements Operand {

    @Override
    /** Subtracts right leaf number from left leaf number. */
    public int calculate() {
        return left.calculate() - right.calculate();
    }

    /**When traversing the tree, returns this operand. */
    public Subtraction() {
        operation = '-';
    }
}
