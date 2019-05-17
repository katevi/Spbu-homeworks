package Vinnik.g144;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ClassPrinterTest {
    @Test
    public void tripleCharClassTest() {
        Vinnik.g144.TripleChar sample = new Vinnik.g144.TripleChar('a');
        ClassPrinter classPrinter = new ClassPrinter();
        StringBuilder tripleCharStructure = new StringBuilder();
        assertEquals("package Vinnik.g144.ResultOfReflection;\n" +
                "\n" +
                "import Vinnik.g144.*;\n" +
                "\n" +
                "public class TripleChar extends Object  {\n" +
                "\tprivate char first = 'x';\n" +
                "\n" +
                "\t\n" +
                "\tTripleChar(char arg0) { }\n" +
                "\n" +
                "\tpublic void triple (char arg0)   {\n" +
                "\t\treturn ;\n" +
                "\t}\n" +
                "}\n" +
                "\n" +
                "\t", classPrinter.printStructure(tripleCharStructure, sample.getClass()).toString());
    }

    @Test
    public void linkedListTest() throws IOException, ClassNotFoundException {
        ClassLoader classLoader = new URLClassLoader(new URL[]{new URL("file://")});

        Class<?> sample1 = classLoader.loadClass("Vinnik.g144.LinkedList");

        ClassPrinter classPrinter = new ClassPrinter();
        StringBuilder linkedListStructure = new StringBuilder();

        char[] expected = ("package Vinnik.g144.ResultOfReflection;\n" +
                "\n" +
                "import Vinnik.g144.*;\n" +
                "\n" +
                "public class LinkedList <Type> extends Object implements List<Type>  {\n" +
                "\tprivate int size = 0;\n" +
                "\n" +
                "\tListElement first = null;\n" +
                "\n" +
                "\t\n" +
                "\tpublic LinkedList() { }\n" +
                "\n" +
                "\tpublic boolean isEmpty ()   {\n" +
                "\t\treturn true;\n" +
                "\t}\n" +
                "\n" +
                "\tpublic int size ()   {\n" +
                "\t\treturn 0;\n" +
                "\t}\n" +
                "\n" +
                "\tpublic void addElement (Object arg0)   {\n" +
                "\t\treturn ;\n" +
                "\t}\n" +
                "\n" +
                "\tpublic void print () throws ListIsEmptyException {\n" +
                "\t\treturn ;\n" +
                "\t}\n" +
                "\n" +
                "\tpublic void removeElement (int arg0) throws IndexOutOfBorderException, ListIsEmptyException {\n" +
                "\t\treturn ;\n" +
                "\t}\n" +
                "\n" +
                "\tpublic boolean exists (Object arg0)   {\n" +
                "\t\treturn true;\n" +
                "\t}\n" +
                "\tprivate class ListElement extends Object  {\n" +
                "\tprivate Object value = null;\n" +
                "\n" +
                "\tprivate ListElement next = null;\n" +
                "\n" +
                "\tfinal LinkedList this$0 = null;\n" +
                "\n" +
                "\t\n" +
                "\tprivate ListElement(LinkedList arg0, Object arg1) { }\n" +
                "\n" +
                "\t\n" +
                "}\n" +
                "\n" +
                "\t\n" +
                "\n" +
                "\t\n" +
                "}\n" +
                "\n" +
                "\t").toCharArray();

        String result = classPrinter.printStructure(linkedListStructure, sample1).toString();
        char[] resultArray = result.toCharArray();

        Arrays.sort(expected);
        Arrays.sort(resultArray);
        assertArrayEquals(expected, resultArray);
    }

    @Test
    public void differenceTripleCharAndDoubleCharTest() throws ClassNotFoundException, IOException {

        ClassLoader classLoader1 = new URLClassLoader(new URL[]{new URL("file://")});

        Class<?> sample1 = classLoader1.loadClass("Vinnik.g144.DoubleChar");
        Class<?> sample2 = classLoader1.loadClass("Vinnik.g144.TripleChar");

        ClassPrinter classPrinter = new ClassPrinter();

        assertFalse(classPrinter.diffClasses(sample1, sample2));
        assertTrue(classPrinter.diffClasses(sample2, sample2));
        assertTrue(classPrinter.diffClasses(sample1, sample1));
    }

    @Test
    public void differenceTripleCharAndLinkedListTest() throws ClassNotFoundException, IOException {

        ClassLoader classLoader1 = new URLClassLoader(new URL[]{new URL("file://")});

        Class<?> sample2 = classLoader1.loadClass("Vinnik.g144.TripleChar");
        Class<?> sample3 = classLoader1.loadClass("Vinnik.g144.LinkedList");

        ClassPrinter classPrinter = new ClassPrinter();

        assertFalse(classPrinter.diffClasses(sample2, sample3));
        assertTrue(classPrinter.diffClasses(sample3, sample3));
        assertTrue(classPrinter.diffClasses(sample2, sample2));
    }

    @Test
    public void checkLoadFromFileAndCompareTest() throws ClassNotFoundException, IOException {
        ClassLoader classLoader1 = new URLClassLoader(new URL[]{new URL("file://")});
        Class<?> linkedListOriginal = classLoader1.loadClass("Vinnik.g144.LinkedList");

        ClassPrinter classPrinter = new ClassPrinter();
        classPrinter.printStructureToFile(linkedListOriginal);

        ClassLoader classLoader2 = new URLClassLoader(new URL[]{new URL("file://")});
        Class<?> linkedListResult = classLoader2.loadClass("Vinnik.g144.ResultOfReflection.LinkedList");
        assertTrue(classPrinter.diffClasses(linkedListOriginal, linkedListResult));
    }
}
