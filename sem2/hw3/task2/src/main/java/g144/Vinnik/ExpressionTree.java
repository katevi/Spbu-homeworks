package g144.Vinnik;


/** Builds the tree according to the parse tree from the file. */
public class ExpressionTree {
    private Operator root;
    int numberOfCharactersProcessed = 0;
    /**
     * Loading tree from file.
     *
     * @param expression print of parse tree from file
     */
    public ExpressionTree(String expression) throws IncorrectFormException {
        if (expression.charAt(expression.length() - 1) == ')') {
            root = getRoot(convertToSuitableForm(expression));
        } else {
            throw new IncorrectFormException();
        }
    }

    //Replaces "( " to "*" and adds tab after
    private StringBuilder convertToSuitableForm(String expression) {
        char[] convertExpression = expression.toCharArray();
        for (int i = 0; i < expression.length() - 1; i++) {
            if (expression.charAt(i) == '(' && expression.charAt(i + 1) == ' ') {
                convertExpression[i + 1] = '*';
            }
        }
        StringBuilder finalExpression = new StringBuilder();
        for (int i = 0; i < expression.length(); i++) {
            finalExpression = finalExpression.append(convertExpression[i]);
            if (convertExpression[i] == '*') {
                finalExpression = finalExpression.append(" ");
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


    private Operator getRoot(StringBuilder expression) throws IncorrectFormException {
        return getOperator(expression);
    }

    private Operator getOperator(StringBuilder string) throws IncorrectFormException {
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

    private int getNumber(StringBuilder str) {
        int answer = 0;

        char currentSymbol = str.charAt(numberOfCharactersProcessed);
        while ((currentSymbol > '0') && (currentSymbol < '9')) {
            answer *= 10;
            answer += currentSymbol - '0';
            numberOfCharactersProcessed++;
            currentSymbol = str.charAt(numberOfCharactersProcessed);
        }

        return answer;
    }
}
