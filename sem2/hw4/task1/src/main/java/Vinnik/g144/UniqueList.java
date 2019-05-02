package Vinnik.g144;

/** List with non-repeating elements. */
public class UniqueList<Type> extends LinkedList<Type> {

    /**
     * If list had not given value yet, adds element value to the current list,
     * if element already was in list, throws exception.
     *
     * @param value the value of the element to add to the list.
     * @throws RepeatingElementException - this exception method throws, if element already was in list.
     */
    @Override
    public void addElement(Type value) throws RepeatingElementException {
        if (this.exists(value)) {
            throw new RepeatingElementException();
        }
        super.addElement(value);
    }
}
