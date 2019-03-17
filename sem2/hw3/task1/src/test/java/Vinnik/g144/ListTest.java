package Vinnik.g144;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListTest {

    @Test
    void addElement() {
        List<Integer> list = new List();
        list.addElement(4);
        list.addElement(5);
        list.addElement(5);
        list.addElement(3);
        list.addElement(5);
        assertEquals(3, list.size());
    }

    @Test
    void removeElement() throws ListIsEmptyException {
        List<Integer> list = new List();
        list.addElement(4);
        list.addElement(5);
        list.addElement(5);
        list.addElement(3);
        list.removeElement(3);
        assertEquals(2, list.size());
    }

    @Test
    void exists() throws ListIsEmptyException {
        List<Integer> list = new List();
        assertFalse(list.exists(4));
        list.addElement(4);
        assertTrue(list.exists(4));
        list.removeElement(4);
        assertFalse(list.exists(4));
    }

    @Test
    void isEmpty() throws ListIsEmptyException {
        List<Integer> list = new List();
        assertTrue(list.isEmpty());
        list.addElement(4);
        assertFalse(list.isEmpty());
        list.removeElement(4);
        assertTrue(list.isEmpty());
    }
}