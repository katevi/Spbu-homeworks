package Vinnik.g144;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;

/** Implementation of simple trie (stores strings). */
public class Trie implements Serializable {
    private TrieNode root;
    private int size = 0;
    private LinkedList<String> elements = new LinkedList<>();

    public Trie() {
        root = new TrieNode();
    }

    /**
     * Implements the addition of the given string to the current trie.
     *
     * @param word - given string.
     * @return - returns true, if the trie did not have this string, false otherwise.
     */
    public boolean insert(String word) {
        if (!contains(word)) {
            TrieNode current = root;
            elements.add(word);
            current.numberOfStringsWithPrefixWhichFinishInThisSymbol++;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                TrieNode node = current.children.get(c);
                if (node == null) {
                    node = new TrieNode();
                    current.children.put(c, node);
                }
                current = node;
                current.numberOfStringsWithPrefixWhichFinishInThisSymbol++;
            }
            // Set end to true
            size++;
            current.isEndOfWord = true;
            return true;
        } else {
            return false;
        }
    }

    /** Returns size of current trie. */
    public int size() {
        return size;
    }

    /**
     * Checks if there is a given string in the current trie.
     *
     * @param word - given string.
     * @return - return true, if there is, false otherwise.
     */
    public boolean contains(String word) {
        TrieNode current = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            TrieNode node = current.children.get(c);
            if (node == null) {
                return false;
            }
            current = node;
        }
        return current.isEndOfWord;
    }

    /**
     * Removes given string from current trie.
     *
     * @param word - given string.
     * @return - returns true, if trie had this string before, false if it had not.
     */
    public boolean delete(String word) {
        if (contains(word)) {
            delete(root, word, 0);
            elements.remove(word);
            size--;
            return true;
        } else {
            return false;
        }
    }

    private boolean delete(TrieNode current, String word, int index) {
        if (index == word.length()) {
            if (!current.isEndOfWord) {
                return false;
            }
            current.isEndOfWord = false;
            current.numberOfStringsWithPrefixWhichFinishInThisSymbol--;
            return current.children.isEmpty();
        }
        char symbol = word.charAt(index);
        TrieNode node = current.children.get(symbol);
        node.numberOfStringsWithPrefixWhichFinishInThisSymbol--;
        if (node == null) {
            return false;
        }
        boolean shouldDeleteCurrentNode = delete(node, word, index + 1) && !node.isEndOfWord;

        if (shouldDeleteCurrentNode) {
            current.children.remove(symbol);
            return current.children.isEmpty();
        }
        return false;
    }

    /**
     * Counts number of string, which starts with given prefix.
     * (Example: "aabb" is string, which belongs to set of strings with prefix "aa").
     *
     * @param prefix - given prefix.
     * @return - returns number of strings.
     */
    public int numberOfStringWithPrefix(String prefix) {
        TrieNode current = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            TrieNode node = current.children.get(c);
            if (node == null) {
                return 0;
            }
            current = node;
        }
        return current.numberOfStringsWithPrefixWhichFinishInThisSymbol;
    }

    /**
     * Simple serialize.
     *
     * @param outputStream stream to write trie in.
     * @throws IOException when there are no opportunity write there.
     */
    public void serialize(OutputStream outputStream) throws IOException {
        BufferedWriter outputFile = new BufferedWriter(new OutputStreamWriter(outputStream));

        for (String word: elements) {
            outputFile.write(word);
            outputFile.write("\n");
        }

        outputFile.close();
        outputStream.close();
    }


    /**
     * Simple deserialize.
     *
     * @param inputStream stream to take trie.
     * @throws IOException when there are no opportunity read this stream.
     */
    public void deserialize(InputStream inputStream) throws IOException {
        BufferedReader inputFile = new BufferedReader(new InputStreamReader(inputStream));
        Trie trie = new Trie();

        while (inputFile.ready()) {
            trie.insert(inputFile.readLine());
        }

        root = trie.root;
        size = trie.size;

        inputFile.close();
        inputStream.close();
    }

    private class TrieNode implements Serializable {
        private HashMap<Character, TrieNode> children;
        private int numberOfStringsWithPrefixWhichFinishInThisSymbol = 0;
        private boolean isEndOfWord;
        public TrieNode() {
            children = new HashMap<>();
            isEndOfWord = false;
        }
    }
}
