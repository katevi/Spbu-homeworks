package Vinnik.g144;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {

    @Test
    void compareToTest() {
        Node<Integer> node1 = new Node<>(5, null);
        Node<Integer> node2 = new Node<>(6, null);
        assertTrue(node1.compareTo(node2) < 0);
    }

    @Test
    void toStringTest() {
        BalanceTree tree = new BalanceTree();
        String result = "( 5 ( 4 null null ) ( 6 null null ))";
        tree.add(5);
        tree.add(4);
        tree.add(6);
        assertEquals(result, tree.toString());
    }

    @Test
    void addNodeTest() {
        BalanceTree tree = new BalanceTree();
        assertThrows(IllegalArgumentException.class, ()->tree.add(null));
    }
}
