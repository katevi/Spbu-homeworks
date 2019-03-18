package Vinnik.g144;

public interface List<Type> {
    void addElement(Type value) throws RepeatingElementException;
    void removeElement(int index) throws IndexOutOfBorderException, ListIsEmptyException;
    void print() throws ListIsEmptyException;
    boolean exists(Type value);
    int size();
    boolean isEmpty();
}
