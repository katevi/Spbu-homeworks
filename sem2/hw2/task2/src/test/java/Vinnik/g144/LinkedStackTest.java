package Vinnik.g144;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedStackTest {

    @Test
    public void pop() {
        LinkedStack stack = new LinkedStack();
        stack.push(4);
        stack.push(3);
        assertEquals(3, stack.pop());
        assertEquals(4, stack.pop());
    }

    @Test
    public void isEmpty() {
        LinkedStack stack = new LinkedStack();
        boolean result = stack.isEmpty();
        assertEquals(true, result);
    }

    @Test
    public void top() {
        LinkedStack stack = new LinkedStack();
        stack.push(2);
        stack.push(4);
        stack.push(3);
        assertEquals(3, stack.top());
    }
}

