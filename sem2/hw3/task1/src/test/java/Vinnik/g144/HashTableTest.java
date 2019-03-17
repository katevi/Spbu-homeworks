package Vinnik.g144;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {
    @Test
    void addElementTest() {
        HashTable table = new ListHashTable(new HashFunctionSum());
        table.addElement("abc");
        table.addElement("bcd");
        table.addElement("5_r");
        assertTrue(table.exists("abc"));
        assertTrue(table.exists("bcd"));
        assertTrue(table.exists("5_r"));
    }

    @Test
    void removeElementTest() throws ListIsEmptyException {
        HashTable table = new ListHashTable(new HashFunctionSum());
        table.addElement("abc");
        table.addElement("5_r");
        assertTrue(table.exists("5_r"));
        assertTrue(table.exists("abc"));

        table.removeElement("abc");
        assertFalse(table.exists("abc"));
        table.removeElement("5_r");
        assertFalse(table.exists("5_r"));
    }

    @Test
    void existsTest() throws ListIsEmptyException {
        HashTable table = new ListHashTable(new HashFunctionSum());
        assertFalse(table.exists("5_r"));
        assertFalse(table.exists("abc"));
        table.addElement("5_r");
        table.addElement("abc");
        assertTrue(table.exists("abc"));
        assertTrue(table.exists("5_r"));

        table.removeElement("abc");
        assertFalse(table.exists("abc"));
        table.removeElement("5_r");
        assertFalse(table.exists("5_r"));
    }

    @Test
    void numberOfConflictsTest() {
        HashTable table = new ListHashTable(new HashFunctionSum());
        table.addElement("de");
        assertEquals(0, table.numberOfConflicts());
        table.addElement("x[");
        //(int) d = 100; (int) e = 101; 100 + 101 * 2 = 302
        //(int) x = 120; (int) [ = 91; 120 + 91 * 2 = 302
        assertEquals(1, table.numberOfConflicts());
    }

    @Test
    void numberOfOccupiedCellsTest() {
        HashTable table = new ListHashTable(new HashFunctionSum());
        table.addElement("x");
        table.addElement("x");
        table.addElement("y");
        table.addElement("z");
        assertEquals(3, table.numberOfOccupiedCells());
    }

    @Test
    void maxLengthOfConflictTest() {
        HashTable table = new ListHashTable(new HashFunctionSum());
        table.addElement("de");
        assertEquals(1, table.maxLengthOfConflict());
        table.addElement("x[");
        //(int) d = 100; (int) e = 101; 100 + 101 * 2 = 302
        //(int) x = 120; (int) [ = 91; 120 + 91 * 2 = 302
        assertEquals(2, table.maxLengthOfConflict());
        table.addElement("bf");
        //(int) b = 98; (int) f = 102; 98 + 102 * 2 = 302
        assertEquals(3, table.maxLengthOfConflict());
    }
}