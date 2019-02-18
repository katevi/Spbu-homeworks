package Vinnik.g144;

/**
 * Implements simple stack.
 */
public class Stack<Type>{
    private class StackElement {

        public Type value;
        public StackElement next;

        public StackElement(Type value, StackElement next) {
            this.value = value;
            this.next = next;
        }
    }

    private StackElement head = null;

    /**
     * @param value - value of adding element
     */
    public void push(Type value){
        head = new StackElement(value, head);
    }

    /**
     * @return - returns value of the top element, removed element before.
     */
    public Type pop() {
        if (!isEmpty()) {
            Type value = head.value;
            head = head.next;
            return value;
        }
        return null;
    }

    /**
     * @return - returns true if the stack is empty and false otherwise.
     */
    public boolean isEmpty() {
        return (head == null);
    }

    /**
     * @return - return the value of the top element
     */
    public Type top(){
        return head.value;
    }
}
