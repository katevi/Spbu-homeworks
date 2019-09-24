package Vinnik.g144;

/**
 * Implements an interface for working with different lists.
 *
 * @param <Type> - type of list elements.
 */
public interface List<Type> {
    void addElement(Type value) throws RepeatingElementException;
    void removeElement(int index) throws Exception;
    void print() throws Exception;
    boolean exists(Type value);
    int size();
    boolean isEmpty();
}
