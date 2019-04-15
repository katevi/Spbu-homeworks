package Vinnik.g144;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExpressionTreeTest {

    @Test
    void outputTest() throws IncorrectFormException {
        ExpressionTree tree = new ExpressionTree("( (+ 1 1) 2)");
        assertEquals("(* (+ 1 1) 2)", tree.output());
    }

    @Test
    void calculateCorrectFormTest() throws IncorrectFormException {
        String expression = "( (+ 3 2) (- 1 5))";
        ExpressionTree tree = new ExpressionTree(expression);
        assertEquals(-20, tree.calculate());
    }

    @Test
    void calculateInCorrectFormExpressionHasOnlyNumber() {
        String expression = "(1)";
        assertThrows(IncorrectFormException.class, () -> new ExpressionTree(expression));
    }

    @Test
    void calculateIncorrectFormTestWhenNonExistingSign() {
        String expression = "(% 1 2)";
        assertThrows(IncorrectFormException.class, () -> new ExpressionTree(expression));
    }

    @Test
    void calculateIncorrectFormTestWithoutFirstBracket() {
        String expression = "+ 1 2)";
        assertThrows(IncorrectFormException.class, () -> new ExpressionTree(expression));
    }

    @Test
    void calculateIncorrectFormTestWithoutSecondBracket() {
        String expression = "(+ 1 2";
        assertThrows(IncorrectFormException.class, () -> new ExpressionTree(expression));
    }
}