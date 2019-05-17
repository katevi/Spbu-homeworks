package Vinnik.g144;


/** Calculates simple arithmetic expressions using the sorting station algorithm. */
public class Calculator {
    private static Stack<Character> operations;
    private static Stack<Float> result;
    private static int numberOfProcessedCharacters = 0;

    Calculator(LinkedStack<Character> symbolStack, LinkedStack<Float> integerStack) {
        operations = symbolStack;
        result = integerStack;
    }

    private String convertToPostfix(String expression) {
        char expressionInPostfixForm[] = new char[100];
        for (int i = 0; i < expression.length(); i++)
            if ((expression.charAt(i) >= '0') && (expression.charAt(i) <= '9')) {
                expressionInPostfixForm[numberOfProcessedCharacters] = expression.charAt(i);
                numberOfProcessedCharacters++;
            } else {
                if ((expression.charAt(i) == '+') || (expression.charAt(i) == '-')) {
                    writeSecondPriorityOperator(expressionInPostfixForm, expression, i);
                }
                if ((expression.charAt(i) == '*') || (expression.charAt(i) == '/')) {
                    writeFirstPriorityOperator(expressionInPostfixForm, expression, i);
                }
                if (expression.charAt(i) == '(') {
                    operations.push(expression.charAt(i));
                }
                if (expression.charAt(i) == ')') {
                    while (operations.top() != '(') {
                        expressionInPostfixForm[numberOfProcessedCharacters] = operations.pop();
                        numberOfProcessedCharacters++;
                    }
                    operations.pop();
                }
            }
        while (!operations.isEmpty()) {
            expressionInPostfixForm[numberOfProcessedCharacters] = operations.pop();
            numberOfProcessedCharacters++;
        }
        setEndOfExpressionSymbol(expressionInPostfixForm, expression);
        return new String(expressionInPostfixForm);
    }

    private void writeSecondPriorityOperator(char[] expressionInPostfix, String expression, int currentSymbol) {
        if (operations.isEmpty()) {
            operations.push(expression.charAt(currentSymbol));
        } else {
            while ((!operations.isEmpty()) && (operations.top() != '(')) {
                expressionInPostfix[numberOfProcessedCharacters] = operations.pop();
                numberOfProcessedCharacters++;
            }
            operations.push(expression.charAt(currentSymbol));
        }
    }

    private void writeFirstPriorityOperator(char[] expressionInPostfix, String expression, int currentSymbol) {
        if (operations.isEmpty() || operations.top() == '+' || operations.top() == '-' || operations.top() == '(') {
            operations.push(expression.charAt(currentSymbol));
        } else {
            expressionInPostfix[numberOfProcessedCharacters] = operations.pop();
            numberOfProcessedCharacters++;
            operations.push(expression.charAt(currentSymbol));
        }
    }

    private void setEndOfExpressionSymbol(char[] expressionInPostfixForm, String expression) {
        if (numberOfProcessedCharacters <= expression.length()) {
            expressionInPostfixForm[numberOfProcessedCharacters] = '#';
        }
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

    private Float calculateResultOfExpression(String expressionInPostfixForm) throws IncorrectFormException {
        float a = 0;
        float b = 0;
        char[] finalString = removeTabsFromPostfixForm(expressionInPostfixForm);
        int countOfNumbersInStack = 0;
        for (int i = 0; i < finalString.length; i++) {
            if (finalString[i] >= '0' && finalString[i] <= '9') {
                countOfNumbersInStack++;
                result.push((float) (finalString[i]) - '0');
            } else {
                if ((finalString[i] == '-') && (countOfNumbersInStack == 1)) {
                    result.push(-result.pop());
                } else {
                    try {
                        a = result.pop();
                        b = result.pop();
                    } catch (java.util.EmptyStackException e) {
                        throw new IncorrectFormException();
                    }
                    result.push(operate(b, a, finalString[i]));
                    countOfNumbersInStack--;
                }
            }
        }
        return result.pop();
    }

    private Float operate(Float a, Float b, char operator) throws IncorrectFormException {
        switch (operator) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
            default:
                throw new IncorrectFormException();
        }
    }

    /** Returns result of computing of arithmetic expression. */
    public Float calculate(String expression) throws IncorrectFormException {
        try {
            String postfix = convertToPostfix(expression);
            Float result = calculateResultOfExpression(postfix);
            return result;
        } catch (IncorrectFormException e) {
            throw new IncorrectFormException();
        }
    }
}
