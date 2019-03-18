package Vinnik.g144;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListTest {
    @Test
    void addElementTest() throws RepeatingElementException {
        List <Integer> list = new LinkedList<>();
        list.addElement(12);
        assertTrue(list.exists(12));
        list.addElement(13);
        assertTrue(list.exists(13));
        list.addElement(12);
        assertTrue(list.exists(12));
        list.addElement(14);
        assertTrue(list.exists(14));
    }

    @Test
    void removeExistingElementInTest() throws IndexOutOfBorderException, ListIsEmptyException, RepeatingElementException {
        List <Integer> list = new LinkedList<>();
        list.addElement(12);
        list.removeElement(0);
        assertFalse(list.exists(12));
    }

    @Test
    public void removeNotExistingElementInTest() {
        List <Integer> list = new LinkedList<>();
        assertThrows(IndexOutOfBorderException.class, ()-> list.removeElement(5));
    }

    @Test
    void existsTest() throws IndexOutOfBorderException, ListIsEmptyException, RepeatingElementException {
        List <Integer> list = new LinkedList<>();
        assertFalse(list.exists(12));
        assertFalse(list.exists(125));
        list.addElement(12);
        assertTrue(list.exists(12));
        list.removeElement(0);
        assertFalse(list.exists(12));
    }

    @Test
    void isEmptyTest() throws IndexOutOfBorderException, ListIsEmptyException, RepeatingElementException {
        List <Integer> list = new LinkedList<>();
        assertTrue(list.isEmpty());
        list.addElement(5);
        assertFalse(list.isEmpty());
        list.removeElement(0);
        assertTrue(list.isEmpty());
    }

    @Test
    void print() {
        List <Integer> list = new LinkedList<>();
        assertThrows(ListIsEmptyException.class, ()-> list.print());
    }

    @Test
    void sizeTest() throws RepeatingElementException {
        List <Integer> list = new LinkedList<>();
        list.addElement(12);
        list.addElement(13);
        list.addElement(12);
        list.addElement(14);
        assertEquals(4, list.size());
    }
}