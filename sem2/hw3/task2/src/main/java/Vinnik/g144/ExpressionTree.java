package Vinnik.g144;

import java.io.*;

/** Builds the tree according to the parse tree from the file. */
public class ExpressionTree {
    private Operator root;

    /**
     * Loading tree from file.
     *
     * @param expression print of parse tree from file
     * */

    public ExpressionTree(String expression) {
        root = getRoot(convertToSuitableForm(expression));
    }

    //Replaces "( " to "*" and added tab after
    private String convertToSuitableForm(String expression) {
        char[] convertExpression = expression.toCharArray();
        for (int i = 0; i < expression.length() - 1; i++) {
            if (expression.charAt(i) == '(' && expression.charAt(i + 1) == ' ') {
                convertExpression[i + 1] = '*';
            }
        }
        String finalExpression = "";
        for (int i = 0; i < expression.length(); i++) {
            finalExpression = finalExpression + convertExpression[i];
            if (convertExpression[i] == '*') {
                finalExpression = finalExpression + " ";
            }
        }
        return finalExpression;
    }

    /** Prints arithmetic expression. */
    public String output() {
        return root.output();
    }

    /** Returns result of calculating. */
    public int calculate() {
        return root.calculate();
    }


    private Operator getRoot(String expression) {
        int[] i = new int[1];
        i[0] = 0;

        return getOperator(expression, i);
    }

    private Operator getOperator(String string, int[] i) {
        Operator operator = null;
        i[0]++;

        switch (string.charAt(i[0])) {
            case '+': {
                operator = new Addition();
                break;
            }
            case '-': {
                operator = new Subtraction();
                break;
            }
            case '*': {
                operator = new Multiplication();
                break;
            }
            case '/': {
                operator = new Division();
                break;
            }
        }
        i[0] += 2;

        if (string.charAt(i[0]) == '(') {
            operator.setLeft(getOperator(string, i));
        } else {
            operator.setLeft(new Number(getNumber(string, i)));
        }

        i[0]++;
        if (string.charAt(i[0]) == '(') {
            operator.setRight(getOperator(string, i));
        } else {
            operator.setRight(new Number(getNumber(string, i)));
        }

        i[0]++;

        return operator;
    }

    private int getNumber(String str, int[] i) {
        int answer = 0;

        while ((str.charAt(i[0]) > '0') && (str.charAt(i[0]) < '9')) {
            answer *= 10;
            answer += str.charAt(i[0]) - '0';
            i[0]++;
        }

        return answer;
    }
}
