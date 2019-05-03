package Vinnik.g144;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class TrieTest {

    @Test
    void insertTest() {
        Trie trie = new Trie();

        assertEquals(0, trie.size());

        trie.insert("Programming");
        assertEquals(1, trie.size());

        trie.insert("is");
        assertEquals(2, trie.size());

        trie.insert("a");
        assertEquals(3, trie.size());

        trie.insert("way");
        assertEquals(4, trie.size());

        trie.insert("of");
        assertEquals(5, trie.size());
        assertTrue(trie.contains("of") && trie.contains("way")
                && !trie.contains("life") && trie.contains("Programming") && trie.contains("is") && trie.contains("a"));

        trie.insert("life");
        trie.insert("life");
        trie.insert("life");
        assertEquals(6, trie.size());
    }

    @Test
    void containsTest() {
        Trie trie = new Trie();

        assertEquals(0, trie.size());
        assertFalse(trie.contains("Programming"));

        trie.insert("Programming");
        assertEquals(1, trie.size());
        assertTrue(trie.contains("Programming"));

        trie.insert("is");
        assertEquals(2, trie.size());
        assertTrue(trie.contains("is"));

        trie.insert("a");
        assertEquals(3, trie.size());
        assertTrue(trie.contains("a"));
    }

    @Test
    void sizeTest() {
        Trie trie = new Trie();

        assertEquals(0, trie.size());
        assertFalse(trie.contains("Programming"));

        trie.insert("Programming");
        assertEquals(1, trie.size());

        trie.insert("is");
        assertEquals(2, trie.size());

        trie.insert("Programming");
        assertEquals(2, trie.size());

        trie.delete("Programming");
        assertEquals(1, trie.size());

        trie.delete("is");
        assertEquals(0, trie.size());
    }

    @Test
    void deleteTest() {
        Trie trie = new Trie();
        assertFalse(trie.delete("Programming"));
        assertFalse(trie.delete("P"));
        assertFalse(trie.delete(" "));

        assertFalse(trie.contains("Programming"));
        assertFalse(trie.contains("P"));
        assertFalse(trie.contains(" "));

        assertTrue(trie.insert("P"));
        assertTrue(trie.insert("Programming"));
        assertTrue(trie.insert(" "));
        assertEquals(3, trie.size());

        assertTrue(trie.delete("P"));
        assertTrue(trie.delete(" "));
        assertTrue(trie.delete("Programming"));

        assertFalse(trie.contains(" "));
        assertFalse(trie.contains("Programming"));
        assertFalse(trie.contains("P"));
        assertEquals(0, trie.size());
    }

    @Test
    void getAllStringsWithPrefixTest() {
        Trie trie = new Trie();

        trie.insert("Programming");
        assertEquals(1, trie.numberOfStringWithPrefix("Pro"));

        trie.insert("Problem");
        assertEquals(2, trie.numberOfStringWithPrefix("Pro"));

        trie.insert("Progress");
        assertEquals(3, trie.numberOfStringWithPrefix("Pro"));

        trie.insert("Porter");
        assertEquals(3, trie.numberOfStringWithPrefix("Pro"));
        assertEquals(2, trie.numberOfStringWithPrefix("Prog"));
        assertEquals(1, trie.numberOfStringWithPrefix("Prob"));
        assertEquals(1, trie.numberOfStringWithPrefix("Progre"));
        assertEquals(1, trie.numberOfStringWithPrefix("Progra"));
        assertEquals(1, trie.numberOfStringWithPrefix("Por"));
        assertEquals(0, trie.numberOfStringWithPrefix("Porr"));

        trie.delete("Porter");
        assertEquals(3, trie.numberOfStringWithPrefix("Pro"));

        trie.delete("Progress");
        assertEquals(2, trie.numberOfStringWithPrefix("Pro"));

        trie.delete("Progress");
        assertEquals(2, trie.numberOfStringWithPrefix("Pro"));

        trie.delete("Problem");
        assertEquals(1, trie.numberOfStringWithPrefix("Pro"));

        trie.delete("Programmer");
        assertEquals(1, trie.numberOfStringWithPrefix("Pro"));

        trie.delete("Programming");
        assertEquals(0, trie.numberOfStringWithPrefix("Pro"));
    }

    @Test
    public void serializeAndDeserializeTest() throws IOException {
        Trie bor = new Trie();

        bor.insert("Problem");
        bor.insert("Progress");
        bor.insert("P");

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        bor.serialize(outputStream);

        bor.insert("Cat");
        bor.insert("Meow");
        bor.delete("P");
        bor.delete("Problem");
        bor.delete("Progress");

        ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
        bor.deserialize(inputStream);

        assertEquals(3, bor.size());
        assertFalse(bor.contains("Cat"));
        assertFalse(bor.contains("Meow"));
        assertTrue(bor.contains("P"));
        assertTrue(bor.contains("Problem"));
        assertTrue(bor.contains("Progress"));
    }
}