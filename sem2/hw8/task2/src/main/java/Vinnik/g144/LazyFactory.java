package Vinnik.g144;

import java.util.function.Supplier;


/** Class, which creates lazy objects. */
public class LazyFactory {

    /**
     * Implements get() for single thread.
     *
     * @param supplier - function to be used.
     * @param <Type> - this type will return get().
     * @return - result of computing function.
     */
    public static <Type> Lazy<Type> createLazySingleThread(Supplier<Type> supplier) {
        return new Lazy<>() {

            private boolean wasComputed = false;
            private Type value = null;

            @Override
            public Type get() {
                if (wasComputed) {
                    return value;
                }

                if (supplier != null) {
                    value = supplier.get();
                } else {
                    value = null;
                }

                wasComputed = true;
                return value;
            }
        };
    }


    /**
     * Implements get() for multi thread.
     *
     * @param supplier - function to be used.
     * @param <Type> - this type will return get().
     * @return - result of computing function.
     */
    public static <Type> Lazy<Type> createLazyMultiThread(Supplier<Type> supplier) {
        return new Lazy<>() {

            private volatile boolean wasComputed = false;
            private volatile Type value = null;

            @Override
            public Type get() {
                if (!wasComputed) {
                    synchronized (this) {
                        if (!wasComputed) {
                            if (supplier != null) {
                                value = supplier.get();
                            } else {
                                value = null;
                            }
                            wasComputed = true;
                        }
                    }
                }
                return value;
            }
        };
    }
}