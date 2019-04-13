package Vinnik.g144;

import org.junit.Test;

import java.util.*;

import static Vinnik.g144.SecondPartTasks.*;
import static org.junit.Assert.*;

public class SecondPartTasksTest {

    @Test
    public void testFindQuotes() {
        assertEquals(Arrays.asList("bcdfg", "bcbc"), findQuotes(Arrays.asList("bcdfg", "cba", "bcbc"), "bc"));
        assertEquals(Arrays.asList("goose", "work in google", "amazing zoo"), findQuotes(Arrays.asList("goose", "work in google", "amazing zoo"), "oo"));
        assertEquals(Arrays.asList("goose", "work in google"), findQuotes(Arrays.asList("goose", "work in google", "amazing zoo"), "goo"));
        assertEquals(Arrays.asList(), findQuotes(Arrays.asList("bcdfg", "cba", "bcbc"), "aaa"));
    }

    @Test
    public void testPiDividedBy4() {
        assertEquals(3.1415 / 4, piDividedBy4(), 0.001);
    }

    @Test
    public void testFindPrinter() {
        Map<String, List<String>> compositions = new HashMap<>();
        assertEquals("", findPrinter(compositions));
        compositions.put("Bcbc", Arrays.asList("uuub", "bbbba", "cccdd", "dfgdfbdfb"));
        compositions.put("Bcerr", Arrays.asList("uuub", "bbbba", "cccdd", "dfdfb", "werwewrewr"));
        compositions.put("Bcvbcvbb", Arrays.asList("uuub", "bbbba"));
        assertEquals("Bcerr", findPrinter(compositions));
        compositions.put("AAAAA", Arrays.asList("uu", "bb", "cc"));
        assertEquals("Bcerr", findPrinter(compositions));
        compositions.put("Byyy", Arrays.asList("uuub", "bbbba", "cccdd", "dfdfb", "werwewrewr", "fglkhhfghf"));
        assertEquals("Byyy", findPrinter(compositions));
    }

    @Test
    public void testCalculateGlobalOrder() {
        Map<String, Integer> first = new HashMap<>();
        Map<String, Integer> second = new HashMap<>();
        Map<String, Integer> third = new HashMap<>();

        first.put("item1", 10);
        first.put("item2", 50);
        first.put("item3", 20);
        first.put("item4", 40);

        second.put("item1", 50);
        second.put("item2", 20);
        second.put("item5", 100);

        third.put("item1", 15);
        third.put("item2", 17);
        third.put("item3", 22);

        Map<String, Integer> result = new HashMap<>();
        result.put("item1", 10 + 50 + 15);
        result.put("item2", 50 + 20 + 17);
        result.put("item3", 20 + 22);
        result.put("item4", 40);
        result.put("item5", 100);

        assertEquals(result, calculateGlobalOrder(Arrays.asList(first, second, third)));
    }
}