package Vinnik.g144;

/**Implements a specific hash function (polynomial hash function). */
public class HashFunctionPolynom implements HashFunction {
    /** For a given string and the maximum hash size calculates hash function. */
    public int hash(String string, int mod) {
        int prime = 7;
        int result = 0;
        for (int i = 0; i < string.length(); i++) {
            result = ((result + (int)(string.charAt(i))) * prime) % mod;
        }
        return result;
    }
}
