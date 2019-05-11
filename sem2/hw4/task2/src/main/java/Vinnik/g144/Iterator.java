package Vinnik.g144;


import java.util.Iterator;
import java.util.NoSuchElementException;

/** Class, that implements simple balance tree iterator. */
class BalanceTreeIterator<Type extends Comparable<Type>> implements Iterator<Type> {
    private Node<Type> next;

    public BalanceTreeIterator(Node<Type> node) {
        next = node;
        if (next == null) {
            return;
        }
        while (next.getLeft() != null) {
            next = next.getLeft();
        }
    }

    /** Checks if there is next node. */
    @Override
    public boolean hasNext() {
        return next != null;
    }

    /** Returns next node value. */
    @Override
    public Type next() {
        if (!hasNext()) throw new NoSuchElementException();
        Node<Type> result = next;

        if (next.getRight() != null) {
            next = next.getRight();
            while (next.getLeft() != null)
                next = next.getLeft();
            return result.getValue();
        }

        while (true) {
            if (next.getParent() == null) {
                next = null;
                return result.getValue();
            }
            if (next.getParent().getLeft() == next) {
                next = next.getParent();
                return result.getValue();
            }
            next = next.getParent();
        }
    }
}