package Vinnik.g144;

/** Class for arithmetic operations on numbers.*/
public class Calculator {
    /** Applies the given operator to the two numbers. */
    protected static double calculate(int first, int second, String c) {
        double result = 0;
        switch (c) {
            case "+": {
                result = first + second;
                break;
            }
            case "-" : {
                result = first - second;
                break;
            }
            case "*" : {
                result = first * second;
                break;
            }
            case "/" : {
                result = (double) first / second;
                break;
            }
        }
        return result;
    }
}
