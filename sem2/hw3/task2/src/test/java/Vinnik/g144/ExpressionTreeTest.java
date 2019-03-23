package Vinnik.g144;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExpressionTreeTest {

    @Test
    void outputTest() {
        ExpressionTree tree = new ExpressionTree("( (+ 1 1) 2)");
        assertEquals("(* (+ 1 1) 2)", tree.output());
    }

    @Test
    void calculateTest() {
        String expression = "( (+ 1 1) 2)";
        ExpressionTree tree = new ExpressionTree(expression);
        assertEquals(4, tree.calculate());
    }
}