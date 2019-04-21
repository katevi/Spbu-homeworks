package Vinnik.g144;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PriorityQueueTest {

    @Test
    void enqueueTest() throws QueueIsEmptyException {
        PriorityQueue <Integer> queue = new PriorityQueue<>();
        queue.enqueue(5, 3);
        queue.enqueue(6, 3);
        queue.enqueue(7, 1);
        queue.enqueue(11, 1);
        assertEquals(4, queue.size());
        queue.enqueue(12, 2);
        queue.enqueue(13, 4);
        queue.enqueue(0, 4);
        queue.enqueue(8, 2);
        queue.enqueue(8, 1);
        assertEquals(9, queue.size());
        assertEquals(13, (int) queue.dequeue());
        assertEquals(0, (int) queue.dequeue());
        assertEquals(5, (int) queue.dequeue());
        assertEquals(6, (int) queue.dequeue());
        assertEquals(12, (int) queue.dequeue());
        assertEquals(8, (int) queue.dequeue());
        assertEquals(7, (int) queue.dequeue());
        assertEquals(11, (int) queue.dequeue());
        assertEquals(8, (int) queue.dequeue());
        assertEquals(0, queue.size());
    }

    @Test
    void isEmptyTest() throws QueueIsEmptyException {
        PriorityQueue <Integer> queue = new PriorityQueue<>();
        assertTrue(queue.isEmpty());
        queue.enqueue(5, 2);
        assertFalse(queue.isEmpty());
        queue.dequeue();
        assertTrue(queue.isEmpty());
    }

    @Test
    void dequeueWhenIsEmptyQueueTest() throws QueueIsEmptyException {
        PriorityQueue <Integer> queue = new PriorityQueue<>();
        assertThrows(QueueIsEmptyException.class, ()->queue.dequeue());
    }

    @Test
    void dequeueTest() throws QueueIsEmptyException {
        PriorityQueue <Integer> queue = new PriorityQueue<>();
        queue.enqueue(5, 1);
        queue.enqueue(6, 3);
        queue.enqueue(7, 2);
        queue.enqueue(11, 1);
        assertEquals(6, (int) queue.dequeue());
        assertEquals(7, (int) queue.dequeue());
        assertEquals(5, (int) queue.dequeue());
        assertEquals(11, (int) queue.dequeue());
    }

    @Test
    void sizeTest() throws QueueIsEmptyException {
        PriorityQueue <Integer> queue = new PriorityQueue<>();
        assertEquals(0, queue.size());
        queue.enqueue(5, 1);
        assertEquals(1, queue.size());
        queue.enqueue(6, 2);
        queue.enqueue(7, 3);
        queue.enqueue(11, 1);
        assertEquals(4, queue.size());
        queue.dequeue();
        assertEquals(3, queue.size());
        queue.dequeue();
        assertEquals(2, queue.size());
        queue.dequeue();
        assertEquals(1, queue.size());
        queue.dequeue();
        assertEquals(0, queue.size());
    }
}
