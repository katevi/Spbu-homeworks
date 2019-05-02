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

    @Override
    /** Adds given string to hash table. */
    public void addElement(String value) {
        int index = this.hashFunction.hash(value, lengthOfArray);
        list[index].addElement(value);
    }

    @Override
    /** Removes given string from hash table. */
    public void removeElement(String value) throws ListIsEmptyException {
        int index = this.hashFunction.hash(value, lengthOfArray);
        list[index].removeElement(value);
    }

    @Override
    /** Checks if given string is in hash table */
    public boolean exists(String value) {
        int index = this.hashFunction.hash(value, lengthOfArray);
        return this.list[index].exists(value);
    }

    @Override
    /** Calculates number of collisions in hash table. */
    public int numberOfConflicts() {
        int result = 0;
        for (int i = 0; i < lengthOfArray; i++) {
            if (this.list[i].size() > 1) {
                // one element in list is not a collision yet
                result = result + (list[i].size() - 1);
            }
        }
        return result;
    }

    @Override
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

    @Override
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

    @Override
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
