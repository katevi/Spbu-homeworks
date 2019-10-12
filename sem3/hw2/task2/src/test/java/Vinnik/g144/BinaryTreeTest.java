package Vinnik.g144;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

    @Test
    void addNodeTest() {
        BinaryTree <Integer> tree = new BinaryTree();
        tree.add(5);
        assertTrue(tree.contains(5));
        tree.add(5);
        assertTrue(tree.contains(5));
        tree.remove(5);
        assertFalse(tree.contains(5));
        tree.add(6);
        tree.add(7);
        assertTrue(tree.contains(6));
        assertTrue(tree.contains(7));
    }

    @Test
    void existsTest() {
        BinaryTree <Integer> tree = new BinaryTree();
        assertFalse(tree.contains(5));
        tree.add(5);
        assertTrue(tree.contains(5));
        tree.add(4);
        tree.add(6);
        assertTrue(tree.contains(4));
        assertTrue(tree.contains(6));
        tree.remove(5);
        assertFalse(tree.contains(5));
        assertTrue(tree.contains(4));
        assertTrue(tree.contains(6));
        assertFalse(tree.contains(123));
    }

    @Test
    void removeNodeTest() {
        BinaryTree <Integer> tree = new BinaryTree();
        tree.add(5);
        assertTrue(tree.contains(5));
        tree.add(4);
        tree.add(6);
        assertTrue(tree.contains(4));
        assertTrue(tree.contains(6));
        tree.remove(5);
        tree.remove(4);
        tree.remove(6);
        assertFalse(tree.contains(5));
        assertFalse(tree.contains(4));
        assertFalse(tree.contains(6));
    }
}