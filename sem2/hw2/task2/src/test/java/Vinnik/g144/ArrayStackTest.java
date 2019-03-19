package Vinnik.g144;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayStackTest {

    @Test
    public void popTest() {
        ArrayStack stack = new ArrayStack();
        stack.push(4);
        stack.push(3);
        assertEquals(3, stack.pop());
        assertEquals(4, stack.pop());
    }

    @Test
    public void topTest() {
        ArrayStack stack = new ArrayStack();
        stack.push(2);
        stack.push(4);
        stack.push(3);
        assertEquals(3, stack.top());
    }

    @Test
    public void isEmptyTest() {
        ArrayStack stack = new ArrayStack();
        boolean result = stack.isEmpty();
        assertEquals(true, result);
    }

    @Test
    public void currentSizeTest() {
        ArrayStack stack = new ArrayStack();
        stack.push(2);
        stack.push(4);
        stack.push(3);
        assertEquals(3, stack.currentSize());
    }

    @Test
    public void doubleSizeTest() {
        ArrayStack stack = new ArrayStack();
        stack.push(2);
        stack.push(4);
        stack.push(3);
        stack.push(3);
        assertEquals(4, stack.currentSize());
    }
}
