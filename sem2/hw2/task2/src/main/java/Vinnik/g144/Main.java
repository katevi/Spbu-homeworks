package Vinnik.g144;
import java.util.Scanner;


/** Implements a simple calculator of arithmetic expressions with digits. (Example (5+3-2*6)). */
public class Main {

    public static void main(String args[]) {
        LinkedStack<Character> stack1 = new LinkedStack();
        LinkedStack<Float> stack2 = new LinkedStack();
        Calculator calculator = new Calculator(stack1, stack2);
        String expression = input();
        try {
            System.out.println("Value of this expression = " + calculator.calculate(expression));
        } catch (IncorrectFormException e) {
            System.out.println("Incorrect form of expression!");
        }
    }

    /** The user enters an expression that he wants to calculate. */
    public static String input() {
        System.out.println("Enter expression:");
        Scanner scan = new Scanner(System.in);
        String expression = scan.nextLine();
        return expression;
    }
}
