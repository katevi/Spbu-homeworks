package Vinnik.g144;

public class PriorityQueue <Type> {
    private QueueElement first;
    private int size;

    /** Adds element with priority to the queue (min priority = -inf).
     * Element with priority 3 has smaller priority than element with priority 4.
     *
     * @param element - value of adding element
     * @param priority - priority of adding element
     * */
    public void enqueue(Type element, int priority) {
        if (isEmpty()) {
            first = new QueueElement(element, priority, null);
            size++;
            return;
        } else {
            if (first.priority < priority) {
                first = new QueueElement(element, priority, first);
                size++;
                return;
            } else {
                if (size == 1) {
                    first.next = new QueueElement(element, priority, null);
                    size++;
                    return;
                }

                QueueElement current = first;
                while (current.next != null) {
                    if (current.next.priority < priority) {
                        current.next = new QueueElement(element, priority, current.next);
                        size++;
                        return;
                    }
                    current = current.next;
                }

                current.next = new QueueElement(element, priority, null);
                size++;
            }
        }
    }

    /** Checks queue for the emptiness, returns true if queue is empty, false otherwise. */
    public boolean isEmpty() {
        return (first == null);
    }

    /** Returns element of the current queue with max priority and deletes it from the queue. */
    public Type dequeue() throws QueueIsEmptyException {
        if (isEmpty()) {
            throw new QueueIsEmptyException();
        }
        QueueElement previousHead = first;
        first = first.next;
        size--;
        return previousHead.value;
    }

    /** Returns size of current queue (number of elements). */
    public int size() {
        return size;
    }

    /** Class, implementing element of the queue. */
    private class QueueElement {
        public Type value;
        private int priority;
        private QueueElement next;

        /** Constructor, which creates new element.
         *
         * @param value - value of new element of queue
         * @param priority - priority of new element of queue
         * @param next - link to the next element of queue
         */
        private QueueElement(Type value, int priority, QueueElement next) {
            this.value = value;
            this.priority = priority;
            this.next = next;
        }
    }
}
