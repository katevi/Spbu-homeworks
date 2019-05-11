package Vinnik.g144;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class BalanceTreeTest {

    @Test
    void addTest() {
        BalanceTree <Integer> tree = new BalanceTree<>();
        assertFalse(tree.contains(5));
        assertFalse(tree.contains(6));
        assertFalse(tree.contains(7));
        tree.add(5);
        tree.add(6);
        tree.add(7);
        assertTrue(tree.contains(5));
        assertTrue(tree.contains(6));
        assertTrue(tree.contains(7));
    }

    @Test
    void addAllTest() {
        BalanceTree <Integer> tree1 = new BalanceTree<>();
        Collection <Integer> collection = new ArrayList<>();
        collection.add(9);
        collection.add(10);
        tree1.add(5);
        tree1.add(6);
        tree1.add(7);
        assertEquals(3, tree1.size());
        assertTrue(tree1.addAll(collection));
        assertFalse(tree1.addAll(collection));
        assertEquals(5, tree1.size());
        tree1.remove(5);
        tree1.remove(6);
        tree1.remove(7);
        assertEquals(2, tree1.size());
        assertFalse(tree1.addAll(collection));
        assertEquals(2, tree1.size());
    }

    @Test
    void removeTest() {
        BalanceTree <Integer> tree = new BalanceTree<>();
        assertFalse(tree.contains(7));
        assertFalse(tree.contains(1));
        tree.add(7);
        tree.add(1);
        assertTrue(tree.contains(7));
        assertTrue(tree.contains(1));
        tree.remove(7);
        tree.remove(1);
        assertFalse(tree.contains(7));
        assertFalse(tree.contains(1));
    }

    @Test

    void removeAllTest() {
        BalanceTree <Integer> tree1 = new BalanceTree<>();
        Collection <Integer> collection = new ArrayList<>();
        collection.add(6);
        collection.add(7);
        tree1.add(5);
        tree1.add(6);
        tree1.add(7);
        assertEquals(3, tree1.size());
        assertTrue(tree1.removeAll(collection));
        assertEquals(1, tree1.size());
        tree1.remove(5);
        assertFalse(tree1.removeAll(collection));
    }

    @Test
    void containsTest() {
        BalanceTree tree = new BalanceTree();
        assertFalse(tree.contains(14));
        assertFalse(tree.contains(11));
        assertFalse(tree.contains(13));
        tree.add(11);
        tree.add(13);
        assertFalse(tree.contains(14));
        assertTrue(tree.contains(11));
        assertTrue(tree.contains(13));
        assertFalse(tree.contains(14));
    }

    @Test
    void isEmptyTest() {
        BalanceTree tree = new BalanceTree();
        assertTrue(tree.isEmpty());
        tree.add(13);
        assertFalse(tree.isEmpty());
    }

    @Test
    void toArrayTest() {
        BalanceTree tree = new BalanceTree();
        tree.add(5);
        tree.add(6);
        tree.add(7);
        Integer result[] = {5, 6, 7};
        assertArrayEquals(result, tree.toArray());
    }

    @Test
    void retainAllTest() {
        BalanceTree tree = new BalanceTree();
        Collection <Integer> collection = new ArrayList<>();
        tree.add(5);
        tree.add(6);
        tree.add(7);
        tree.add(8);
        assertTrue(tree.retainAll(collection));
        collection.add(6);
        collection.add(7);
        assertFalse(tree.retainAll(collection));
    }

    @Test
    void sizeTest() {
        BalanceTree tree = new BalanceTree();
        assertEquals(0, tree.size());
        tree.add(5);
        assertEquals(1, tree.size());
        tree.add(8);
        assertEquals(2, tree.size());
        tree.remove(102);
        assertEquals(2, tree.size());
        tree.remove(5);
        assertEquals(1, tree.size());
        tree.remove(8);
        assertEquals(0, tree.size());
    }

    @Test
    void clearTest() {
        BalanceTree tree = new BalanceTree();
        assertTrue(tree.isEmpty());
        tree.add(5);
        tree.add(8);
        tree.add(9);
        assertFalse(tree.isEmpty());
        tree.clear();
        assertTrue(tree.isEmpty());
    }

}

