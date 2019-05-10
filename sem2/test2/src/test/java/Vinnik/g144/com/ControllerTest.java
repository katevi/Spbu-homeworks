package Vinnik.g144.com;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    @Test
    void convertInput() {
        String[][] array = {{"abc abc"}, {"bfg"}, {"dflk lkj"}, {"lksjd", "sdfmnb", "sldkfjlsd"}, {"mnsdbmb"}, {}};
        Controller controller = new Controller();

        LinkedList<LinkedList<String>> result = new LinkedList<>();
        LinkedList<String> first = new LinkedList<>();
        result.add(first);

        LinkedList<String> second = new LinkedList<>();
        second.add("bfg");
        result.add(second);

        LinkedList<String> third = new LinkedList<>();
        third.add("mnsdbmb");
        result.add(third);

        LinkedList<String> fourth = new LinkedList<>();
        fourth.add("abc");
        fourth.add("abc");
        result.add(fourth);

        LinkedList<String> fifth = new LinkedList<>();
        fifth.add("dflk");
        fifth.add("lkj");
        result.add(fifth);

        LinkedList<String> sixth = new LinkedList<>();
        sixth.add("lksjd");
        sixth.add("sdfmnb");
        sixth.add("sldkfjlsd");
        result.add(sixth);

        SortedSet set = controller.convertInput(array);
        assertEquals(result, set.getStrings());
    }

}