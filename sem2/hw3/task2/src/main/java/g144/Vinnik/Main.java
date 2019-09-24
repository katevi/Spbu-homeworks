package g144.Vinnik;

import java.io.*;
import java.io.FileReader;

/** Example of work with parse tree.*/
public class Main {
    public static void main(String[] args) {
        String nameOfFile = "src/main/java/Vinnik/g144/Expression.txt";
        String expression = null;

        try (FileReader reader = new FileReader(nameOfFile)) {
            BufferedReader in = new BufferedReader(reader);
            expression = in.readLine();
        } catch(IOException e) {
            System.out.println("File not found :(");
        }

        try {
            ExpressionTree tree = new ExpressionTree(expression);
            System.out.println("Tree from file: " + tree.output());
            System.out.println("Result of arithmetic expression: " + tree.calculate());
        } catch (IncorrectFormException e) {
            System.out.println("Incorrect form exception");
        }
    }
}
