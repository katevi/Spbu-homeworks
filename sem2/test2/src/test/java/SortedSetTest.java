package g144.Vinnik;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class SortedSetTest {

    @Test
    void sort() {
        LinkedList<String>[] lists = new LinkedList[3];

        for (int i = 0; i < lists.length; i++) {
            lists[i] = new LinkedList<String>();
        }
        lists[1].add("abs");
        lists[1].add("sldkjf");
        lists[1].add("ldfknvldn");

        lists[2].add("aksjdbaksjd");
        lists[2].add("kdjfndvndmnv");

        lists[0].add("eoirjlg");
        LinkedList[] result = new LinkedList[]{lists[0], lists[2], lists[1]};
        SortedSet<String> set = new SortedSet<>();
        set.sort(lists);
        assertArrayEquals(result, lists);
    }
}