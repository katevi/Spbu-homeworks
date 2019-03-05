package Vinnik.g144;
import java.util.Arrays;
import java.util.Scanner;

/** Implements a simple calculator of arithmetic expressions. (Example (5+3-2*6))**/
public class Main {

    public static void main(String args[]) {
        LinkedStack<Character> stack1 = new LinkedStack();
        LinkedStack<Float> stack2 = new LinkedStack();
        Calculator calculator = new Calculator(stack1, stack2);
        String expression = calculator.input();
        System.out.println("Value of this expression = " + calculator.calculate(expression));
    }
}
