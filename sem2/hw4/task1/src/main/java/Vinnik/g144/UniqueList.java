package Vinnik.g144;

/** List with non-repeating elements. */
public class UniqueList<Type> extends LinkedList<Type> {
    @Override
    public void addElement(Type value) throws RepeatingElementException {
        if (this.exists(value)) {
            throw new RepeatingElementException();
        }
        super.addElement(value);
    }
}
