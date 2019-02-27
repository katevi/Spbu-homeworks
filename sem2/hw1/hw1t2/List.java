package Vinnik.g144;

/**
 *A class that implements a simple single-linked list.
 *
 * @param <Type> type of elements of list
 */
public class List<Type>{
    private class ListElement{
        public Type value;
        public ListElement next;
        public ListElement(Type value) {
            this.value = value;
            this.next = null;
        }
    }

    ListElement first = null;

    /**
     * Adding element in the end of list.
     *
     * @param value the value of the element to add to the list
     */
    public void addElement(Type value){
        if (isEmpty()){
            first = new ListElement(value);
            return;
        }
        ListElement current = first;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new ListElement(value);
    }

    public int size() {
        ListElement current = first;
        int size = 0;
        while (current != null){
            size++;
            current = current.next;
        }
        return size;
    }

    /**
     * Deletes the list element by the entered value.
     *
     * @param index value of the list element to be deleted
     */
    public void removeElement(int index) {
        ListElement current = first;
        if (index > size()) {
            return;
        }
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        current.next = current.next.next;

        System.out.println("No such element");
    }

    /**
     *By the entered value checks if there is an element in the list.
     *
     * @param value the value of the element whose presence in the list should be checked
     * @return true if there is such an element in the list, false otherwise
     */
    public boolean isExists(Type value) {
        ListElement current = first;
        while (current != null) {
            if (current.value == value){
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
}
