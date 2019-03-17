package Vinnik.g144;

/** Implements the simplest hash table, collision resolution by separate chaining (array of lists). */
public class ListHashTable implements HashTable {
    private int lengthOfArray = 10000;
    private List<String>[] list = new List[this.lengthOfArray];
    private HashFunction hashFunction;

    ListHashTable(HashFunction hashFunction) {
        this.hashFunction = hashFunction;
        for (int i = 0; i < lengthOfArray; i++) {
            list[i] = new List();
        }
    }

    /** Adds given string to hash table. */
    public void addElement(String value) {
        int index = this.hashFunction.hash(value, lengthOfArray);
        list[index].addElement(value);
    }

    /** Removes given string from hash table. */
    public void removeElement(String value) throws ListIsEmptyException {
        int index = this.hashFunction.hash(value, lengthOfArray);
        list[index].removeElement(value);
    }

    /** Checks if given string is in hash table */
    public boolean exists(String value) {
        int index = this.hashFunction.hash(value, lengthOfArray);
        return this.list[index].exists(value);
    }

    /** Calculates number of collisions in hash table. */
    public int numberOfConflicts() {
        int result = 0;
        for (int i = 0; i < lengthOfArray; i++) {
            if (this.list[i].size() > 1) {
                result++;
            }
        }
        return result;
    }

    /** Calculates number of non-empty cells in hash table. */
    public int numberOfOccupiedCells() {
        int result = 0;
        for (int i = 0; i < lengthOfArray; i++) {
            if (this.list[i].size() > 0) {
                result++;
            }
        }
        return result;
    }

    /** Calculates max size of collision in hash table (max size of list). */
    public int maxLengthOfConflict() {
        int max = 0;
        for (int i = 0; i < lengthOfArray; i++) {
            if (this.list[i].size() > max) {
                max = this.list[i].size();
            }
        }
        return max;
    }

    /** Prints information about hash table. */
    public void printStatistics() {
        System.out.println("Number of cells: " + lengthOfArray);
        System.out.println("Number of conflicts: " + numberOfConflicts());
        System.out.println("Number of unempty cells: " + numberOfOccupiedCells());
        double loadFactor = (double)(lengthOfArray - numberOfOccupiedCells()) / lengthOfArray;
        System.out.println("Load factor: " + loadFactor);
        if (maxLengthOfConflict() > 1) {
            System.out.println("Max size of conflict: " + maxLengthOfConflict());
        } else {
            System.out.println("No conflicts.");
        }
    }
}
