package Vinnik.g144;

public interface List<Type, S, M> {
    void addElement(Type value);
    void removeElement(int index) throws IndexOutOfBorderException, ListIsEmptyException;
    void print() throws ListIsEmptyException;
    boolean exists(Type value);
    int size();
    boolean isEmpty();
}
