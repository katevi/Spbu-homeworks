package Vinnik.g144.com;

import java.util.LinkedList;

/** Implements sorted set. */
public class SortedSet<Type> implements ListComparator<Type> {


    private LinkedList<LinkedList<String>> strings = new LinkedList<LinkedList<String>>();
    private int size = 0;

    /** Sorts lists with strings in set in ascending order. */
    public <Type> void sort(LinkedList<LinkedList<String>> lists) {
        for (int i = lists.size() - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (compare(lists.get(j), lists.get(j + 1)) > 0) {
                    LinkedList tmp = lists.get(j);
                    lists.add(j, lists.get(j + 1));
                    lists.remove(j + 1);
                    lists.add(j + 1, tmp);
                    lists.remove(j + 2);
                }
            }
        }
    }

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
        strings.add(list);
        size = size + list.size();
        sort(strings);
    }
}
