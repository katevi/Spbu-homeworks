package g144.Vinnik;

/** Class, responsible for the two numbers division. */
public class Division extends Operator implements Operand {

    @Override
    /** Divides the left leaf number by the second. */
    public int calculate() {
        return left.calculate() / right.calculate();
    }

    /** When traversing the tree, returns this operand. */
    public Division() {
        operation = '/';
    }
}
