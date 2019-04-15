package Vinnik.g144;


/** Builds the tree according to the parse tree from the file. */
public class ExpressionTree {
    private Operator root;
    int numberOfCharactersProcessed = 0;
    /**
     * Loading tree from file.
     *
     * @param expression print of parse tree from file
     * */

    public ExpressionTree(String expression) throws IncorrectFormException {
        if (expression.charAt(expression.length() - 1) == ')') {
            root = getRoot(convertToSuitableForm(expression));
        } else {
            throw new IncorrectFormException();
        }
    }

    //Replaces "( " to "*" and adds tab after
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


    private Operator getRoot(String expression) throws IncorrectFormException {
        return getOperator(expression);
    }

    private Operator getOperator(String string) throws IncorrectFormException {
        Operator operator = null;
        numberOfCharactersProcessed++;

        switch (string.charAt(numberOfCharactersProcessed)) {
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
            default: {
                throw new IncorrectFormException();
            }
        }
        numberOfCharactersProcessed += 2;

        if (string.charAt(numberOfCharactersProcessed) == '(') {
            operator.setLeft(getOperator(string));
        } else {
            operator.setLeft(new Number(getNumber(string)));
        }

        numberOfCharactersProcessed++;
        if (string.charAt(numberOfCharactersProcessed) == '(') {
            operator.setRight(getOperator(string));
        } else {
            operator.setRight(new Number(getNumber(string)));
        }

        numberOfCharactersProcessed++;

        return operator;
    }

    private int getNumber(String str) {
        int answer = 0;

        while ((str.charAt(numberOfCharactersProcessed) > '0') && (str.charAt(numberOfCharactersProcessed) < '9')) {
            answer *= 10;
            answer += str.charAt(numberOfCharactersProcessed) - '0';
            numberOfCharactersProcessed++;
        }

        return answer;
    }
}
