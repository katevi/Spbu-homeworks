package Vinnik.g144;

import java.util.*;

/** Implementation simple binary tree. */
public class BinaryTree<Type extends Comparable<Type>> implements  Iterable<Type> {
    private Node<Type> root;

    private Node addNode(Node<Type> current, Type value) {
        if (current == null) {
            return new Node(value);
        }

        if (value.compareTo(current.getValue()) < 0) {
            current.setLeft(addNode(current.getLeft(), value));
        } else if (value.compareTo(current.getValue()) > 0) {
            current.setRight(addNode(current.getRight(), value));
        } else {
            // value already exists
            return current;
        }
        return current;
    }

    /** Adds element with given value to current tree. */
    public void add(Type x) {
        root = addNode(root, x);
    }

    private boolean containsNode(Node<Type> current, Type value) {
        if (current == null) {
            return false;
        }
        if (value.compareTo(current.getValue()) == 0) {
            return true;
        }
        return value.compareTo(current.getValue()) < 0
                ? containsNode(current.getLeft(), value)
                : containsNode(current.getRight(), value);

    }

    /** Checks if tree has element with given value. Returns true if tree has, false otherwise. */
    public boolean contains(Type value) {
        return containsNode(root, value);
    }

    private Type minimumNodeInSubtree(Node<Type> current) {
        return current.getLeft() == null ? current.getValue() : minimumNodeInSubtree(current.getLeft());
    }

    private Node removeNode(Node<Type> current, Type value) throws NoSuchElementException {
        if (current == null) {
            throw new NoSuchElementException();
        }
        if (value.compareTo(current.getValue()) == 0) {
            if (current.getLeft() == null && current.getRight() == null) {
                return null;
            }
            if (current.getLeft() == null) {
                return current.getRight();
            }
            if (current.getRight() == null) {
                return current.getLeft();
            }
            Type newValue = minimumNodeInSubtree(current.getRight());
            current.setValue(newValue);
            current.setRight(removeNode(current.getRight(), newValue));
            return current;
        }
        if (value.compareTo(current.getValue()) < 0) {
            current.setLeft(removeNode(current.getLeft(), value));
            return current;
        }
        current.setRight(removeNode(current.getRight(), value));
        return current;
    }

    /** Removes node with given value from current tree. */
    public void remove(Type value) {
        root = removeNode(root, value);
    }


    /** Returns new iterator for current tree. */
    @Override
    public Iterator<Type> iterator() {
        return new BinaryTreeIterator();
    }

    /** Implementation of inner classes. */

    /** Implementation of inner class Node. */
    private class Node<Type extends Comparable<Type>> implements Comparable<Node<Type>> {
        private Type value;
        private Node<Type> left;
        private Node<Type> right;

        private void setValue(Type newValue) {
            value = newValue;
        }

        private Type getValue() {
            return value;
        }

        private Node<Type> getLeft() {
            return left;
        }

        private Node<Type> getRight() {
            return right;
        }

        private void setRight(Node<Type> value) {
            right = value;
        }

        private void setLeft(Node<Type> value) {
            left = value;
        }

        @Override
        public int compareTo(Node<Type> o) {
            return value.compareTo(o.value);
        }

        private Node(Type value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    /** Implementation of inner class iterator. */
    private class BinaryTreeIterator implements Iterator<Type> {
        private LinkedList<Type> elements;

        private BinaryTreeIterator() {
            elements = new LinkedList<>();
            addElement(root);
        }

        private void addElement(Node<Type> node) {
            if (node == null) {
                return;
            }
            addElement(node.getLeft());
            elements.add(node.getValue());
            addElement(node.getRight());
        }

        /** Returns true if there is next element in traversal. */
        @Override
        public boolean hasNext() {
            if (elements.isEmpty()) {
                return false;
            }
            for (Type i : elements) {
                if (contains(i)) {
                    return true;
                }
            }
            return false;
        }

        /** Returns value of the next element in traversal */
        @Override
        public Type next() {
            Type temp = elements.pollFirst();
            while (!(contains(temp))) {
                temp = elements.pollFirst();
                if (temp == null) {
                    throw new NoSuchElementException();
                }
            }
            return temp;
        }

        /** Removes the next element of traversal from current tree. */
        @Override
        public void remove() {
            BinaryTree.this.remove(next());
        }
    }
}


