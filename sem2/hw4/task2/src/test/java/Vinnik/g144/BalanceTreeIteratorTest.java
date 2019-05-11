package Vinnik.g144;

import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class BalanceTreeIteratorTest {

    @Test
    void hasNext() {
        BalanceTree tree = new BalanceTree();
        tree.add("5");
        tree.add("9");
        tree.add("7");
        tree.add("1");
        Iterator<String> iterator = tree.iterator();
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
        BalanceTree tree = new BalanceTree();
        Iterator<String> iterator1 = tree.iterator();
        tree.add("5");
        assertFalse(iterator1.hasNext());
        tree.add("6");
        Iterator<String> iterator2 = tree.iterator();
        assertTrue(iterator2.hasNext());
    }

    @Test
    public void ErrorTest() {
        BalanceTree tree = new BalanceTree();
        Iterator<String> iterator = tree.iterator();
        assertThrows(NoSuchElementException.class, ()->iterator.next());
    }
}