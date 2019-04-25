package Vinnik.g144;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static Vinnik.g144.LazyFactory.createLazyMultiThread;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class LazyTest {
    @Test
    public void singleThreadNumberValueTest() {
        Lazy<Integer> lazy = new LazyFactory().createLazySingleThread(() -> 123);
        assertEquals(123, (int) lazy.get());
        lazy.get();
        lazy.get();
        assertEquals(123, (int) lazy.get());
    }

    @Test
    public void singleThreadNullValueTest() {
        Lazy<Integer> lazy = new LazyFactory().createLazySingleThread(() -> null);
        assertEquals(null, lazy.get());
        lazy.get();
        lazy.get();
        assertEquals(null, lazy.get());
    }

    @Test
    public void singleNullThreadTest() {
        Lazy<Integer> lazy = new LazyFactory().createLazySingleThread(null);
        assertEquals(null, lazy.get());
        lazy.get();
        lazy.get();
        lazy.get();
        assertEquals(null, lazy.get());
    }

    @Test
    public void multiNullThreadTest() {
        Lazy<Integer> lazy = new LazyFactory().createLazyMultiThread(null);
        assertEquals(null, lazy.get());
        lazy.get();
        assertEquals(null, lazy.get());
    }

    @Test
    public void multiThreadNullValueTest() throws InterruptedException {
        final boolean[] isFailed = {false};
        Lazy<Integer> lazy = new LazyFactory().createLazyMultiThread(() -> null);
        Runnable check = () -> isFailed[0] = isFailed[0] || (lazy.get() != null);

        Thread first = new Thread(check);
        Thread second = new Thread(check);

        first.start();
        second.start();

        first.join();
        second.join();

        assertFalse(isFailed[0]);
        assertEquals(null, lazy.get());
    }

    @Test
    public void multiThreadNumberValueTest() throws InterruptedException {
        final boolean[] isFailed = {false};

        Lazy<Integer> lazy = createLazyMultiThread(() -> 123);
        Runnable check = () -> isFailed[0] = isFailed[0] || (lazy.get() != 123);

        Thread firstThread = new Thread(check);
        Thread secondThread = new Thread(check);

        firstThread.start();
        secondThread.start();

        firstThread.join();
        secondThread.join();

        assertFalse(isFailed[0]);
        assertEquals(123, lazy.get().intValue());
    }

    @Test
    public void presenceOfRacesTest() throws InterruptedException {
        LinkedList<Integer> numbers = new LinkedList<>();

        Lazy<Boolean> lazy = createLazyMultiThread(() -> {
            numbers.add(1234);
            return true;
        });

        Runnable check = () -> {
            for (int i = 0; i < 100; i++) {
                lazy.get();
            }
        };

        LinkedList<Thread> threads = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(check));
            threads.get(i).start();
        }

        for (int i = 0; i < 10; i++) {
            threads.get(i).join();
        }

        assertEquals(1, numbers.size());
        assertEquals(1234, (int) numbers.get(0));
    }
}