package Vinnik.g144;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HashFunctionTest {
    @Test
    public void hashFunctionPolynom() {
        HashFunction hashFunction = new HashFunctionPolynom();
        // (int) a = 97
        int expectedHash = (97 * 7) % 3;
        int result = hashFunction.hash("a", 3);
        assertEquals(expectedHash, result);
    }

    @Test
    public void hashFunctionSum() {
        HashFunction hashFunction = new HashFunctionSum();
        // (int) a = 97
        int expectedHash = 97 * 1 % 3;
        int result = hashFunction.hash("a", 3);
        assertEquals(expectedHash, result);
    }

}