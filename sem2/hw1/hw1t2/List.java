package Vinnik.g144;

/**
 *A class that implements a simple single-linked list.
 *
 * @param <Type> type of elements of list
 */
public class List<Type> {

    private int size;
    ListElement first = null;

    /**
     * Adding element in the end of list.
     *
     * @param value the value of the element to add to the list
     */
    public void addElement(Type value) {
        if (isEmpty()){
            first = new ListElement(value);
            size++;
            return;
        }
        ListElement current = first;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new ListElement(value);
        size++;
    }

    public int size() {
        return size;
    }

    /**
     * Deletes the list element by the entered value.
     *
     * @param index value of the list element to be deleted
     */
    public void removeElement(int index) {
        ListElement current = first;
        if (index > size) {
            System.out.println("No such element");
            return;
        }
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        current.next = current.next.next;
        size--;
    }

    /**
     *By the entered value checks if there is an element in the list.
     *
     * @param value the value of the element whose presence in the list should be checked
     * @return true if there is such an element in the list, false otherwise
     */
    public boolean exists(Type value) {
        ListElement current = first;
        while (current != null) {
            if (current.value.equals(value)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /**
     * Checks the list for emptiness.
     *
     * @return true if list it empty, false otherwise
     */
    public boolean isEmpty() {
        return (first == null);
    }

    public void print() {
        ListElement current = first;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }

    private class ListElement {
        private Type value;
        private ListElement next;
        private ListElement(Type value) {
            this.value = value;
            this.next = null;
        }
    }
}
