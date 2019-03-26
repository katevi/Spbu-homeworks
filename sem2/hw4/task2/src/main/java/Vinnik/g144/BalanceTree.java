package Vinnik.g144;

import java.util.ArrayList;
import java.util.Collection;

/**Simple AVL-tree, which implements interface Collection. */
public class BalanceTree<Type extends Comparable<Type>> implements Collection<Type> {

    private Node<Type> root;
    private int size;

    BalanceTree() {
        root = null;
        size = 0;
    }

    void setRoot(Node<Type> node) {
        root = node;
    }

    Node<Type> getRoot() {
        return root;
    }

    @Override
    public int size() {
        return size;
    }

    /**Checks collection for the emptiness, returns true if is empty, false otherwise. */
    @Override
    public boolean isEmpty() {
        return root == null;
    }

    /**Checks whether collection has object, returns true if object alredy exists, false otherwise.
     *
     * @param value - value of adding element
     * */
    @Override
    public boolean contains(Object value) {
        return !isEmpty() && root.isContainsNode((Type) value, this);
    }

    /**Implements simple ABL-tree iterator. */
    @Override
    public BalanceTreeIterator<Type> iterator() {
        return new BalanceTreeIterator<>(root);
    }

    /**Returns Object array, which has all elements of the collection. */
    @Override
    public Object[] toArray() {
        return toArray(new Object[size]);
    }

    /** Returns elements' type array, which has all elements of the collection. */
    @Override
    public <Type1> Type1[] toArray(Type1[] array) {
        ArrayList<Type1> arrayList = new ArrayList<>();
        for (Type temp : this) {
            arrayList.add((Type1) temp);
        }

        return arrayList.toArray(array);
    }

    /**Adds one element to the collection - return true, if element was added successful, false otherwise.
     *
     * @param value - value of adding element
     * */
    @Override
    public boolean add(Type value) {
        if (root == null) {
            root = new Node<>(value, null);
            size = 1;
            return true;
        } else {
            if (contains(value)) {
                return false;
            }
            size++;
            root.addNode(value, this);
            return true;
        }
    }

    /** Removes one element from the collection - return true, if element was added successful, false otherwise.
     *
     * @param value
     */
    @Override
    public boolean remove(Object value) {
        if (contains(value)) {
            size--;
            root.removeNode((Type) value, this);
            return true;
        }
        return false;
    }

    /** Checks if current collection has all element from entered collection -
     * returns true if there are all elements in current collection, false otherwise.
     *
     * @param collection - entered collection, where elements from
     * */
    @Override
    public boolean containsAll(Collection<?> collection) {
        boolean result = true;
        for (Object temp : collection) {
            result = result && contains(temp);
        }
        return result;
    }

    /** Adds all elements from the entered collection to the current collection -
     * returns true if all elements was successfully added, false otherwise.
     *
     * @param collection - entered collection
     */
    @Override
    public boolean addAll(Collection<? extends Type> collection) {
        boolean result = true;
        for (Type temp : collection) {
            result = result && add(temp);
        }
        return result;
    }

    /** Removes all elements from the entered collection in the current collection -
     * returns true if all elements was successfully removed, false otherwise.
     *
     * @param collection - entered collection
     * */
    @Override
    public boolean removeAll(Collection<?> collection) {
        boolean result = true;
        for (Object temp : collection) {
            result = result && remove(temp);
        }
        return result;
    }

    /** Removes all entered collection objects from the current collection.
     * If the current collection has changed, returns true, otherwise returns false.
     *
     * @param collection - entered collection
     * */
    @Override
    public boolean retainAll(Collection<?> collection) {
        boolean result = false;
        for (Type temp : this) {
            if (!collection.contains(temp)) {
                remove(temp);
                result = true;
            }
        }
        return result;
    }

    /** Removes all colletion elements.
     */
    @Override
    public void clear() {
        root = null;
    }

    @Override
    public String toString() {
        if (!isEmpty()) {
            return root.toString();
        } else {
            return "null";
        }
    }
}