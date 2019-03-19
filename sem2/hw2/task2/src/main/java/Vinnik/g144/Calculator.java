package Vinnik.g144;

import java.util.Scanner;

/** Calculates simple arithmetic expressions using the sorting station algorithm */
public class Calculator {
    private static Stack<Character> operations;
    private static Stack<Float> result;

    Calculator(LinkedStack<Character> symbolStack, LinkedStack<Float> integerStack) {
        operations = symbolStack;
        result = integerStack;
    }

    /** The user enters an expression that he wants to calculate.*/
    /** The user enters an expression that he wants to calculate*/
    public String input() {
        System.out.println("Enter expression:");
        Scanner scan = new Scanner(System.in);
        String expression = scan.nextLine();
        return expression;
    }

    private String convertToPostfix(String expression) {
        char expressionInPostfix[] = new char[100];
        Integer count = 0;
        for (int i = 0; i < expression.length(); i++)
            if ((expression.charAt(i) >= '0') && (expression.charAt(i) <= '9')) {
                expressionInPostfix[count] = expression.charAt(i);
                count++;
            } else {
                if ((expression.charAt(i) == '+') || (expression.charAt(i) == '-')) {
                    // 2 priority operator
                    if (operations.isEmpty()) {
                        operations.push(expression.charAt(i));
                    } else {
                        while ((!operations.isEmpty()) && (operations.top() != '(')) {
                            expressionInPostfix[count] = operations.pop();
                            count++;
                        }
                        operations.push(expression.charAt(i));
                    }
                }

                if ((expression.charAt(i) == '*') || (expression.charAt(i) == '/')) {
                    //1 priority operator
                    if (operations.isEmpty() || operations.top() == '+' || operations.top() == '-' || operations.top() == '(') {
                        operations.push(expression.charAt(i));
                    } else {
                        expressionInPostfix[count] = operations.pop();
                        count++;
                        operations.push(expression.charAt(i));
                    }
                }
                if (expression.charAt(i) == '(') {
                    operations.push(expression.charAt(i));
                }
                if (expression.charAt(i) == ')') {
                    while (operations.top() != '(') {
                        expressionInPostfix[count] = operations.pop();
                        count++;
                    }
                    operations.pop();
                }
            }
        while (!operations.isEmpty()) {
            expressionInPostfix[count] = operations.pop();
            count++;
        }
        if (count <= expression.length()) {
            //sign of end of postfix form of expression
            expressionInPostfix[count] = '#';
        }
        String stringExpressionInPostfix = new String(expressionInPostfix);
        return stringExpressionInPostfix;
    }

    private int lengthOfPostfixForm(String postfixForm) {
        int length = 0;
        while (length < postfixForm.length() - 1 && postfixForm.charAt(length) != '#') {
            length++;
        }
        return length;
    }

    private char[] removeTabsFromPostfixForm(String stringExpressionInPostfixForm) {
        int k = lengthOfPostfixForm(stringExpressionInPostfixForm);
        char finalString[] = new char[k];
        for (int i = 0; i < k; i++) {
            finalString[i] = stringExpressionInPostfixForm.charAt(i);
        }
        return finalString;
    }

    private Float calculateResultFromPostfix(String stringExpressionInPostfix) {
        float a = 0;
        float b = 0;
        float c = 0;
        char[] finalString = removeTabsFromPostfixForm(stringExpressionInPostfix);
        int countOfNumbersInStack = 0;
        for (int i = 0; i < finalString.length; i++) {
            if (finalString[i] >= '0' && finalString[i] <= '9') {
                countOfNumbersInStack++;
                result.push((float) (finalString[i]) - 48);
            } else {
                if ((finalString[i] == '-') && (countOfNumbersInStack == 1)) {
                    result.push(-result.pop());
                } else {
                    a = result.pop();
                    b = result.pop();
                    result.push(operate(b,a,finalString[i]));
                    countOfNumbersInStack--;
                }
            }
        }
        return result.pop();
    }

    private Float operate(Float a, Float b, char operator) {
        switch (operator) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
        }
        return (float) -1;
    }

    /** Returns result of computing of arithmetic expression.*/
    /** returns result of computing of arithmetic expression*/
    public Float calculate(String expression) {
        String postfix = convertToPostfix(expression);
        Float result = calculateResultFromPostfix(postfix);
        return result;
    }
}
