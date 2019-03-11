package Vinnik.g144;

/** Implements simple stack. */
public class Stack<Type> {

    private StackElement head = null;

    /** @param value - value of adding element */
    public void push(Type value) {
        head = new StackElement(value, head);
    }

    /** Returns value of the top element, removed element before, if list is empty returns null.*/
    public Type pop() {
        if (!isEmpty()) {
            Type value = head.value;
            head = head.next;
            return value;
        }
        return null;
    }

    /** Returns true if the stack is empty and false otherwise. */
    public boolean isEmpty() {
        return (head == null);
    }

    /** Returns the value of the top element */
    public Type top() {
        return head.value;
    }

    private class StackElement {

        private Type value;
        private StackElement next;

        private StackElement(Type value, StackElement next) {
            this.value = value;
            this.next = next;
        }
    }

}
