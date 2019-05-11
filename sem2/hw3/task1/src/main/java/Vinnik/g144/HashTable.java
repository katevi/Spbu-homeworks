package Vinnik.g144;

/** Implements interface to work with a simple hash table. */
public interface HashTable {
    void addElement(String value);
    void removeElement(String value) throws Exception;
    boolean exists(String string);
    void printStatistics();
    int numberOfOccupiedCells();
    int numberOfConflicts();
    int maxLengthOfConflict();
}
