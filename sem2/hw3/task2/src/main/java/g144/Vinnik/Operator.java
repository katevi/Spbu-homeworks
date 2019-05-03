package g144.Vinnik;

/** Class for operators - symbols of arithmetic expression (signs and numbers). */
public abstract class Operator implements Operand {
    /** Operation symbol. */
    protected char operation;
    /** Left operand. */
    protected Operand left;
    /** Right operand. */
    protected Operand right;


    /** Prints operation of current vertex and numbers in leafs, otherwise runs recursively. */
    @Override
    public String output() {
        return "(" + operation + " " + left.output() + " " + right.output() + ")";
    }

    /** Calculates expression from current vertex, otherwise runs recursively. */
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
