package Vinnik.g144;

/** Class for operators - symbols of arithmetic expression (signs and numbers). */
public abstract class Operator implements Operand {
    /** Operation symbol. */
    protected char operation;
    /** Left operand. */
    protected Operand left;
    /** Right operand. */
    protected Operand right;


    @Override
    public String output() {
        return "(" + Character.toString(operation) + " " + left.output() + " " + right.output() + ")";
    }

    @Override
    public abstract int calculate();

    /** Sets left operand. */
    public void setLeft(Operand left) {
        this.left = left;
    }

    /** Sets right operand. */
    public void setRight(Operand right) {
        this.right = right;
    }
}
