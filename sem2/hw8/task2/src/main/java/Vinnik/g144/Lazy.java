package Vinnik.g144;

/**
 * An interface representing lazy computation.
 *
 * @param <Type> - get will return this type
 */
public interface Lazy<Type> {
    /**
     * The first call to get() on Lazy causes the calculation and returns the result.
     * Repeated get() calls return the same object as the first call.
     *
     * @return - result of calculation function (computed first time or before).
     */
    Type get();
}
