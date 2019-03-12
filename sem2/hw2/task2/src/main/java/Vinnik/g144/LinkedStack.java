package Vinnik.g144;

import java.util.EmptyStackException;

/** Implements simple single-linked stack.*/
public class LinkedStack <Type> implements Stack <Type> {
    private class StackElement {

        public Type value;
        public StackElement next;

        public StackElement(Type value, StackElement next) {
            this.value = value;
            this.next = next;
        }
    }

    private StackElement head = null;

    /** @param value - value of adding element */
    @Override
    public void push(Type value) {
        head = new StackElement(value, head);
    }

    /** Returns value of the top element, removed element before. */
    @Override
    public Type pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        Type value = head.value;
        head = head.next;
        return value;
    }

    /** Returns true if the stack is empty and false otherwise. */
    @Override
    public boolean isEmpty() {
        return (head == null);
    }

    /** Returns the value of the top element. */
    @Override
    public Type top() {
        if (!isEmpty()) {
            return head.value;
        }
        return null;
    }
}
