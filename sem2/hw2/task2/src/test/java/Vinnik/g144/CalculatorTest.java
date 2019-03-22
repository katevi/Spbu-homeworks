package Vinnik.g144;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    public void calculateTest() {
        LinkedStack<Character> stack1 = new LinkedStack();
        LinkedStack<Float> stack2 = new LinkedStack();
        Calculator calculator = new Calculator(stack1, stack2);
        assertEquals(-8, Math.ceil(calculator.calculate("-5*4/(2+8)-6")));
    }
}