package Vinnik.g144;

/**
 * The example of work with list.
 */
public class Main {
    public static void main(String args[]) {
        List list = new List<Integer>();
        System.out.println("Is list empty? " + list.isEmpty());
        list.addElement(5);
        list.addElement(6);
        list.addElement(7);
        list.addElement(2);
        list.addElement(3);
        list.print();
        System.out.println("Try to remove 3rd element:");
        list.removeElement(3);
        list.print();
        System.out.println("Try to remove 7th element:");
        list.removeElement(7);
        list.print();
        System.out.println("Size of list: " + list.size());
        System.out.println("value 3 is exists, isn't it? " + list.isExists(3));
        System.out.println("value 2 is exists, isn't it? " + list.isExists(2));
    }
}
