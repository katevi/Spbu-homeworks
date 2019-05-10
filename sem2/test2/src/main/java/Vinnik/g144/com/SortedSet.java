package Vinnik.g144.com;

import java.util.LinkedList;
import java.util.Set;

public class SortedSet<Type> implements ListComparator<Type> {

    public LinkedList<LinkedList<String>> strings = new LinkedList<>(){};

    public <Type> void sort(LinkedList<Type>[] lists) {
        for (int i = lists.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (compare(lists[j], lists[j + 1]) > 0) {
                    LinkedList tmp = lists[j];
                    lists[j] = lists[j + 1];
                    lists[j + 1] = tmp;
                }
            }
        }
    }


    @Override
    public int compare(LinkedList first, LinkedList second) {
        if (first.size() > second.size()) {
            return 1;
        }
        if ((first.size() < second.size())) {
            return -1;
        }
        return 0;
    }

    public void add(LinkedList<LinkedList<String>> lists) {
        int sumSize = 0;
        for (int i = 0; i < lists.size(); i++) {
            sumSize = sumSize + lists.get(i).size();
        }
        LinkedList<String>[] arrayOfLists = new LinkedList[sumSize];
        for (int i = 0; i < sumSize; i++) {
            arrayOfLists[i] = new LinkedList<>();
            arrayOfLists[i].addAll(lists.get(i));
        }
        sort(arrayOfLists);
        //strings.add(arrayOfLists);
        for (int i = 0; i < arrayOfLists.length; i++) {
            strings.add(arrayOfLists[i]);
        }
    }
}
