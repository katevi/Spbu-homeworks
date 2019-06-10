package Vinnik.g144;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void calculate() throws IncorrectFormException {
        Stack<String> stack1 = new Stack();
        Stack<Float> stack2 = new Stack();
        Calculator calculator = new Calculator(stack1, stack2);
        assertEquals(-88, Math.ceil(calculator.calculate("- 5 * 44 / 2 + 88 - 66")));
    }
}