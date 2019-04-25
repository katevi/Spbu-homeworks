package Vinnik.g144;

/**
 * An interface representing lazy computation.
 *
 * @param <Type> - get will return this type
 */
public interface Lazy<Type> {
    Type get();
}
