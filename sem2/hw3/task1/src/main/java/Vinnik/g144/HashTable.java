package Vinnik.g144;

public interface HashTable {
    void addElement(String value);
    void removeElement(String value) throws ListIsEmptyException;
    boolean exists(String string);
    void printStatistics();
    int numberOfOccupiedCells();
    int numberOfConflicts();
    int maxLengthOfConflict();
}
