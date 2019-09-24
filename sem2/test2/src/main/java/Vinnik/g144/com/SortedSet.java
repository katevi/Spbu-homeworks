package Vinnik.g144.com;

import java.util.LinkedList;

/** Implements sorted set. */
public class SortedSet<Type> implements ListComparator<Type> {


    private LinkedList<LinkedList<String>> strings = new LinkedList<LinkedList<String>>();
    private int size = 0;

    /** Returns current list with strings. */
    public LinkedList<LinkedList<String>> getStrings() {
        return strings;
    }

    /** Returns current set size. */
    public int getSize() {
        return size;
    }

    @Override
    /** Compares two lists - if first longer, than second, returns 1, if shorter returns -1, if lists are equal returns 0. */
    public int compare(LinkedList first, LinkedList second) {
        if (first.size() > second.size()) {
            return 1;
        }
        if ((first.size() < second.size())) {
            return -1;
        }
        return 0;
    }

    /** Add new list with strings to current set. */
    public void add(LinkedList<String> list) {
        if (getSize() ==  0) {
            strings.add(list);
            size = size + list.size();
            return;
        }
        for (int i = 0; i < strings.size(); i++) {
            if (compare(list, strings.get(i)) <= 0) {
                strings.add(i, list);
                size = size + list.size();
                return;
            }
        }
        strings.add(list);
        size = size + list.size();
    }
}
