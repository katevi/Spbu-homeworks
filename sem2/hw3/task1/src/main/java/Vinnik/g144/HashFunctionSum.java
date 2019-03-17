package Vinnik.g144;

/** Implements a specific hash function. */
public class HashFunctionSum implements HashFunction {
    /** For a given string and the maximum hash size calculates hash function. */
    public int hash(String string, int mod) {
        int result = 0;
        for (int i = 0; i < string.length(); i++) {
            result = (result + (i + 1) * ((int) string.charAt(i))) % mod;
        }
        return result;
    }
}
