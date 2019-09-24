package Vinnik.g144.com;

import java.util.LinkedList;

/** Compares two lists. */
public  interface ListComparator<Type> {
    int compare(LinkedList first, LinkedList second);
}
