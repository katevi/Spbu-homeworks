package Vinnik.g144;

/** Implements interface, which presents different hash functions to work with a hash table.*/
public interface HashFunction {
    int hash(String string, int mod);
}
