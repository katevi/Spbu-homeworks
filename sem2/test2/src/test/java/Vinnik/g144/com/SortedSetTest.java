package Vinnik.g144.com;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class SortedSetTest {

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