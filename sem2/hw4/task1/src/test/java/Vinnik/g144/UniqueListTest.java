package Vinnik.g144;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UniqueListTest {
    @Test
    void addRepeatingElementTest() throws Exception {
        List <Integer> list = new UniqueList<>();
        list.addElement(5);
        assertThrows(RepeatingElementException.class, ()->list.addElement(5));
    }

    @Test
    void addElementTest() throws Exception {
        List <Integer> list = new UniqueList<>();
        list.addElement(5);
        list.addElement(6);
        assertEquals(2, list.size());
    }
}