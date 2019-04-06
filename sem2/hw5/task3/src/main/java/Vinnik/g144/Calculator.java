package Vinnik.g144;

import java.util.Stack;

/** Calculates simple arithmetic expressions using the sorting station algorithm */
public class Calculator {
    private static Stack<String> operations;
    private static Stack<Float> result;

    Calculator(Stack<String> symbolStack, Stack<Float> floatStack) {
        operations = symbolStack;
        result = floatStack;
    }

    private boolean isNumber(String string) {
        return (string.length() > 0 && string.charAt(0) >= '0' && (string.charAt(0) <= '9'));
    }

    private boolean isCorrectExpression(String[] expressionInArray) {
        for (int i = 1; i < expressionInArray.length; i++) {
            if (!isNumber(expressionInArray[i]) && !isNumber(expressionInArray[i-1])) {
                return false;
            }
        }
        return true;
    }

    private String[] convertToPostfix(String expression) throws IncorrectFormException {
        String expressionInArray[] = expression.split(" ");
        if (isCorrectExpression(expressionInArray)) {
            Integer count = 0;
            String expressionInPostfix[] = new String[expressionInArray.length];
            count = 0;
            for (int i = 0; i < expressionInArray.length; i++) {
                if (isNumber(expressionInArray[i])) {
                    expressionInPostfix[count] = expressionInArray[i];
                    count++;
                } else {
                    if (expressionInArray[i].charAt(0) == '+' || expressionInArray[i].charAt(0) == '-') {
                        if (operations.isEmpty()) {
                            operations.push(expressionInArray[i]);
                        } else {
                            while ((!operations.isEmpty())) {
                                expressionInPostfix[count] = operations.pop();
                                count++;
                            }
                            operations.push(expressionInArray[i]);
                        }
                    }
                    if ((expressionInArray[i].charAt(0) == '*') || (expressionInArray[i].charAt(0) == '/')) {
                        //1 priority operator
                        if (operations.isEmpty() || operations.peek().charAt(0) == '+' || operations.peek().charAt(0) == '-') {
                            operations.push(expressionInArray[i]);
                        } else {
                            expressionInPostfix[count] = operations.pop();
                            count++;
                            operations.push(expressionInArray[i]);
                        }
                    }
                }
            }
            while (!operations.isEmpty()) {
                expressionInPostfix[count] = operations.pop();
                count++;
            }
            return expressionInPostfix;
        } else {
            throw new IncorrectFormException();
        }
    }

    private float fromStringToNumber(String string) {
        float result = 0;
        for (int i = 0; i < string.length(); i++) {
            result = result * 10 + string.charAt(i) - '0';
        }
        return result;
    }

    private Float calculateResultFromPostfix(String[] stringExpressionInPostfix) {
        float a = 0;
        float b = 0;
        float c = 0;
        int countOfNumbersInStack = 0;
        for (int i = 0; i < stringExpressionInPostfix.length; i++) {
            if (stringExpressionInPostfix[i].charAt(0) >= '0' && stringExpressionInPostfix[i].charAt(0) <= '9') {
                countOfNumbersInStack++;
                result.push(fromStringToNumber(stringExpressionInPostfix[i]));
            } else {
                if ((stringExpressionInPostfix[i].charAt(0) == '-') && (countOfNumbersInStack == 1)) {
                    result.push(-result.pop());
                } else {
                    a = result.pop();
                    b = result.pop();
                    result.push(operate(b,a,stringExpressionInPostfix[i].charAt(0)));
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
    public Float calculate(String expression) throws IncorrectFormException {
        String[] postfix = convertToPostfix(expression);
        Float result = calculateResultFromPostfix(postfix);
        return result;
    }
}

