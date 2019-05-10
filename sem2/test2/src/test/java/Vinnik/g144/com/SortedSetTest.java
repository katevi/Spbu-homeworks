package Vinnik.g144.com;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class SortedSetTest {

    @Test
    void sort() {
        LinkedList<LinkedList<String>> lists = new LinkedList<>();

        LinkedList<String> first = new LinkedList<>();
        first.add("eoirjlg");
        lists.add(first);

        LinkedList<String> second = new LinkedList<>();
        second.add("abs");
        second.add("sldkjf");
        second.add("ldfknvldn");
        lists.add(second);

        LinkedList<String> third = new LinkedList<>();
        third.add("aksjdbaksjd");
        third.add("kdjfndvndmnv");
        lists.add(third);

       LinkedList<LinkedList<String>> result = new LinkedList();
        result.add(lists.get(0));
        result.add(lists.get(2));
        result.add(lists.get(1));

        SortedSet<String> set = new SortedSet<>();
        set.sort(lists);
        assertEquals(result, lists);
    }

    @Test
    void add() {
        LinkedList<String> first = new LinkedList<>();
        first.add("eoirjlg lkj asmdnbasmbdnmasbd ooii");

        SortedSet<String> set = new SortedSet<>();
        set.add(first);
        assertEquals(1, set.getSize());
        assertEquals("[eoirjlg lkj asmdnbasmbdnmasbd ooii]", set.getStrings().get(0).toString());

        LinkedList<String> second = new LinkedList<>();
        second.add("dfkj");
        second.add("ldkjflkdfg");
        second.add("djk");
        set.add(second);
        assertEquals(4, set.getSize());
        assertEquals("[dfkj, ldkjflkdfg, djk]", set.getStrings().get(1).toString());

    }
}