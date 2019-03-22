package Vinnik.g144;

import java.util.EmptyStackException;

/**Implements simple stack on an array*/
public class ArrayStack <Type> implements Stack <Type> {
    private int maximumSize = 3;
    private int top = -1;
    private Type[] stack = (Type[]) new Object[maximumSize];

    /**Returns number of elements in stack*/
    public int currentSize() {
        return (this.top + 1);
    }

    private void doubleSize() {
        Type[] temp = (Type[]) new Object[stack.length * 2];
        System.arraycopy(stack,0, temp, 0, stack.length);
        maximumSize = maximumSize * 2;
        stack = temp;
    }

    /**@param value value of adding element */
    @Override
    public void push(Type value) {
        if (maximumSize == currentSize()){
            doubleSize();
        }
        this.top++;
        stack[this.top] = value;
    }

    /** Returns value of the last element and removes it after. */
    @Override
    public Type pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        this.top--;
        return stack[this.top + 1];
    }

    /** Only returns value of the last element. */
    @Override
    public Type top() {
        return stack[this.top];
    }

    /** Returns true if the stack is empty and false otherwise. */
    @Override
    public boolean isEmpty() {
        return (this.top == -1);
    }
}
