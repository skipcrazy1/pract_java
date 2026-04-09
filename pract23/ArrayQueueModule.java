package pract23;

//Один элемент в очереди
public class ArrayQueueModule {
    private static final int CAPACITY = 10;
    private static final ArrayQueue queue = new ArrayQueue(CAPACITY);

    private ArrayQueueModule() {} // приватный конструктор

    public static void enqueue(Object item) {
        queue.enqueue(item);
    }

    public static Object element() {
        return queue.element();
    }

    public static Object dequeue() {
        return queue.dequeue();
    }

    public static int size() {
        return queue.size();
    }

    public static boolean isEmpty() {
        return queue.isEmpty();
    }

    public static void clear() {
        queue.clear();
    }

    public static String toStringQueue() {
        return queue.toString();
    }
}