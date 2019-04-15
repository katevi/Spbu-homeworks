package Vinnik.g144;

class Node<Type extends Comparable<Type>> implements Comparable<Node<Type>> {
    private Type value;
    private Node<Type> left;
    private Node<Type> right;
    private Node<Type> parent;
    private int height;

    private void setHeight(int newHeight) {
        height = newHeight;
    }

    private int getHeight() {
        return height;
    }

    private void setValue(Type newValue) {
        value = newValue;
    }

    Type getValue() {
        return value;
    }

    private void setLeft(Node<Type> newLeftNode) {
        left = newLeftNode;
    }

    Node<Type> getLeft() {
        return left;
    }

    private void setRight(Node<Type> newRightNode) {
        right = newRightNode;
    }

    Node<Type> getRight() {
        return right;
    }

    private void setParent(Node<Type> newParent) {
        parent = newParent;
    }

    Node<Type> getParent() {
        return parent;
    }

    private int balanceFactor() {
        int rightHeight = (getRight() == null) ? 0 : getRight().getHeight();
        int leftHeight = (getLeft() == null) ? 0 : getLeft().getHeight();
        return rightHeight - leftHeight;
    }

    private void updateHeight() {
        int heightLeft = getLeft() == null ? 0 : getHeight();
        int heightRight = getRight() == null ? 0 : getHeight();
        if (heightLeft > heightRight) {
            setHeight(heightLeft + 1);
        } else {
            setHeight(heightRight + 1);
        }
    }

    private void rotateLeft(BalanceTree<Type> tree) {
        Node<Type> current = getRight();
        setRight (current.getLeft());
        if (current.getLeft() != null) {
             current.getLeft().setParent(this);
        }
        current.setLeft(this);
        if (getParent() == null) {
            tree.setRoot(current);
        } else {
            if (equals(getParent().getLeft())) {
                parent.setLeft(current);
            } else {
                parent.setRight(current);
            }
        }
        current.setParent(parent);
        setParent(current);

        updateHeight();
        current.updateHeight();
    }

    private void rotateRight(BalanceTree<Type> tree) {
        Node<Type> current = getLeft();
        setLeft(current.getRight());
        if (current.getRight() != null) {
            current.getRight().setParent(this);
        }
        current.setRight(this);
        if (getParent() == null) {
            tree.setRoot(current);
        } else {
            if (equals(getParent().getLeft())) {
                parent.setLeft(current);
            } else {
                parent.setRight(current);
            }
        }
        current.setParent(parent);
        setParent(current);

        updateHeight();
        current.updateHeight();
    }

    private void balance(BalanceTree<Type> tree) {
        updateHeight();

        if (balanceFactor() == 2) {
            if (getRight().balanceFactor() < 0) {
                getRight().rotateRight(tree);
            }
            rotateLeft(tree);
        }

        if (balanceFactor() == -2) {
            if (getLeft().balanceFactor() > 0) {
                getLeft().rotateLeft(tree);
            }
            rotateRight(tree);
        }
    }

    void addNode(Type value, BalanceTree<Type> tree) {
        if (value.compareTo(getValue()) < 0) {
            if (getLeft() == null) {
                setLeft(new Node<>(value, this));
            } else {
                getLeft().addNode(value, tree);
            }
        } else if (value.compareTo(getValue()) > 0) {
            if (getRight() == null) {
                setRight(new Node<>(value, this));
            } else {
                getRight().addNode(value, tree);
            }
        }

        balance(tree);
    }

    boolean isContainsNode(Type value, BalanceTree<Type> tree) {
        Node<Type> temp = tree.getRoot();
        while (temp != null) {
            if (value.equals(temp.getValue())) {
                return true;
            } else if (value.compareTo(temp.getValue()) > 0) {
                temp = temp.getRight();
            } else if (value.compareTo(temp.getValue()) < 0) {
                temp = temp.getLeft();
            }
        }
        return false;
    }

    private Node<Type> findMaximumNode() {
        Node<Type> temp = this;
        while (temp.getRight() != null) {
            temp = temp.getRight();
        }
        return temp;
    }

    void removeNode(Type value, BalanceTree<Type> tree) {
        if (value.equals(getValue())) {
            if ((getRight() != null) && (getLeft() != null)) {
                Node<Type> maxNode = getLeft().findMaximumNode();
                removeNode(maxNode.getValue(), tree);
                setValue(maxNode.getValue());
            } else if (getRight() != null) {
                setValue(getRight().value);
                setRight(null);
            } else if (getLeft() != null) {
                setValue(getLeft().value);
                setLeft(null);
            } else {
                if (getParent() == null) {
                    tree.setRoot(null);
                } else {
                    if (equals(getParent().getLeft())) {
                        getParent().setLeft(null);
                    } else {
                        getParent().setRight(null);
                    }
                }
            }
        } else if (value.compareTo(getValue()) > 0) {
            getRight().removeNode(value, tree);
        } else {
            getLeft().removeNode(value, tree);
        }
    }


    /** Compares two objects of the collection.
     * Returns <0 if value < node.value, 0 if value == node.value, >0 if value > node.value.
     *
     * @param node - node, whose value should be compared.
     * */
    @Override
    public int compareTo(Node<Type> node) {
        return value.compareTo(node.value);
    }

    /**Writes result of tree traversal in string. */
    @Override
    public String toString() {
        String result = "( " + value.toString() + " ";
        if (getLeft() == null) {
            result += "null ";
        } else {
            result += getLeft().toString() + " ";
        }
        if (getRight() == null) {
            result += "null )";
        } else {
            result += getRight().toString() + ")";
        }
        return result;
    }

    /** A class that implements the functionality of tree vertices. */
    Node(Type value, Node<Type> parent) {
        this.value = value;
        this.left = null;
        this.right = null;
        this.parent = parent;
        this.height = 1;
    }
}
