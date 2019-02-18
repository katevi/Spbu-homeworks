package Vinnik.g144;

/**
 * Example of work with simple stack.
 */
public class Main {
    public static void main(String args[])
    {
        Stack <Integer> stack = new Stack <>();
        System.out.println(stack.isEmpty());
        stack.push(5);
        stack.push(3);
        stack.push(8);
        System.out.println(stack.pop());
        System.out.println(stack.top());
        stack.push(12);
        System.out.println(stack.top());
        System.out.println(stack.isEmpty());
    }
}
