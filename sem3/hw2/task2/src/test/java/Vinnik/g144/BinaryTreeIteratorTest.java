package Vinnik.g144;

import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeIteratorTest {

    @Test
    void hasNext() {
        BinaryTree<String> tree = new BinaryTree();

        tree.add("5");
        tree.add("9");
        tree.add("7");
        tree.add("1");

        Iterator<String> iterator = tree.iterator();

        String testTraverse = "";
        for (String i : tree) {
            testTraverse += i + " ";
        }

        String expectedTraverse = "1 5 7 9 ";

        assertEquals(expectedTraverse, testTraverse);
        String expected1 = "1";
        assertTrue(iterator.hasNext());
        assertEquals(expected1, iterator.next());
        String expected5 = "5";
        assertEquals(expected5, iterator.next());
        String expected7 = "7";
        assertEquals(expected7, iterator.next());
        String expected9 = "9";
        assertEquals(expected9, iterator.next());
    }

    @Test
    void next() {
        BinaryTree tree = new BinaryTree();

        Iterator<String> iterator1 = tree.iterator();
        tree.add("5");
        assertFalse(iterator1.hasNext());

        tree.add("6");
        Iterator<String> iterator2 = tree.iterator();
        assertTrue(iterator2.hasNext());
    }

    @Test
    public void simpleRemove() {
        BinaryTree tree = new BinaryTree();

        tree.add("991");
        tree.add("91");
        tree.add("57");
        tree.add("64");

        Iterator<String> iterator = tree.iterator();
        String expected57 = "57";
        assertEquals(expected57, iterator.next());

        iterator.remove();
        String expected91 = "91";
        assertEquals(expected91, iterator.next());

        iterator.remove();
        assertFalse(iterator.hasNext());
    }

    @Test
    void twoIteratorsRemove() {
        BinaryTree tree = new BinaryTree();

        tree.add("5");
        tree.add("3");
        tree.add("4");
        tree.add("2");
        tree.add("6");
        tree.add("7");
        tree.add("8");

        Iterator<String> iterator1 = tree.iterator();
        Iterator<String> iterator2 = tree.iterator();

        iterator1.remove();
        assertEquals("3", iterator1.next());
        assertEquals("3", iterator2.next());

        iterator2.next();
        iterator2.remove();
        assertEquals("4", iterator1.next());
        assertEquals("6", iterator1.next());
        assertEquals("6", iterator2.next());

        assertTrue(iterator1.hasNext());
        assertTrue(iterator2.hasNext());

        iterator1.remove();
        assertEquals("8", iterator1.next());
        assertEquals("8", iterator2.next());

        assertFalse(iterator1.hasNext());
        assertFalse(iterator2.hasNext());
    }

    @Test
    public void checkHasNextWhenTwoIteratorsRemove() {
        BinaryTree<String> tree = new BinaryTree();

        tree.add("5");
        tree.add("3");
        tree.add("4");
        tree.add("2");
        tree.add("6");
        tree.add("7");
        tree.add("8");

        Iterator<String> iterator1 = tree.iterator();
        Iterator<String> iterator2 = tree.iterator();

        iterator1.remove();
        iterator1.remove();
        iterator1.remove();
        assertTrue(iterator1.hasNext());
        assertTrue(iterator2.hasNext());
        assertEquals("5", iterator2.next());
        assertEquals("5", iterator1.next());

        iterator2.next();
        assertEquals("7", iterator2.next());
        assertEquals("6", iterator1.next());
        assertTrue(iterator1.hasNext());
        assertTrue(iterator2.hasNext());

        iterator2.remove();
        assertFalse(iterator2.hasNext());
        assertTrue(iterator1.hasNext());
        iterator1.next();
        assertFalse(iterator1.hasNext());
    }

    @Test
    public void ErrorTest2() {
        BinaryTree tree = new BinaryTree();
        Iterator<String> iterator = tree.iterator();
        assertThrows(NoSuchElementException.class, ()->iterator.next());
    }
}