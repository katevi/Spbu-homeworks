package Vinnik.g144;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ClassPrinterTest {
    @Test
    public void tripleCharClassTest() {
        TripleChar sample = new TripleChar('a');
        System.out.println(ClassPrinter.printStructure(sample.getClass()));
        assertEquals("package Vinnik.g144 ;\n" +
                "public  class TripleChar extends Object  {\n" +
                "\tprivate char first = 'x';\n" +
                "\tpublic void triple(char arg0) { return ; };\n" +
                "\n" +
                "\n" +
                "}", ClassPrinter.printStructure(sample.getClass()));
    }

    @Test
    public void linkedListTest() throws IOException, ClassNotFoundException {
        ClassLoader classLoader = new URLClassLoader(new URL[]{new URL("file://")});
        Class<?> sample1 = classLoader.loadClass("Vinnik.g144.LinkedList");
        char expected[] = ("package Vinnik.g144 ;\n" +
                "public  class LinkedList<Type,S,M> extends Object  implements List<Type,S,M> {\n" +
                "\tprivate int size = 0;\n" +
                "\tprivate ListElement first = null;\n" +
                "\tpublic boolean isEmpty() { return true; };\n" +
                "\tpublic int size() { return 0; };\n" +
                "\tpublic void addElement(Type arg0) { return ; };\n" +
                "\tpublic void print() throws Vinnik.g144.ListIsEmptyException { return ; };\n" +
                "\tpublic boolean exists(Type arg0) { return true; };\n" +
                "\tpublic void removeElement(int arg0) throws Vinnik.g144.IndexOutOfBorderException, Vinnik.g144.ListIsEmptyException { return ; };\n" +
                "\n" +
                "private  class ListElement extends Object  {\n" +
                "\tprivate Object value = null;\n" +
                "\tprivate ListElement next = null;\n" +
                "\tfinal LinkedList this$0 = null;\n" +
                "\n" +
                "\n" +
                "}\n" +
                "}").toCharArray();
        Arrays.sort(expected);
        char[] result = ClassPrinter.printStructure(sample1).toCharArray();
        Arrays.sort(result);
        System.out.println(ClassPrinter.printStructure(sample1));
        assertArrayEquals(expected, result);
        //ClassPrinter.printToFile(sample1);
    }

    @Test
    public void checkLoadFromTest() throws ClassNotFoundException, IOException {

        ClassLoader classLoader1 = new URLClassLoader(new URL[]{new URL("file://")});
        Class<?> sample1 = classLoader1.loadClass("Vinnik.g144.LinkedList");
        ClassPrinter.printToFile(sample1);

        ClassLoader classLoader2 = new URLClassLoader(new URL[]{new URL("file://")});
        Class<?> result = classLoader2.loadClass("Vinnik.g144.LinkedList");
        assertEquals(sample1, result);
        //в файл LinkedList запишется новый класс, не надо запускать этот тест
    }
}
