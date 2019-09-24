package Vinnik.g144;

/** Implements interface for working with different stacks. */
public interface Stack<Type> {
    void push(Type value);
    Type pop();
    Type top();
    boolean isEmpty();
}
