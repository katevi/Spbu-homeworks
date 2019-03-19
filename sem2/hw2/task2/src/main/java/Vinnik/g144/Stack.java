package Vinnik.g144;

public interface Stack<Type> {
    void push(Type value);
    Type pop();
    Type top();
    boolean isEmpty();
}
