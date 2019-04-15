package Vinnik.g144;

public interface List<Type> {
    void addElement(Type value) throws Exception;
    void removeElement(int index) throws Exception;
    void print() throws Exception;
    boolean exists(Type value);
    int size();
    boolean isEmpty();
}
