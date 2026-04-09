package pract23;

//Абстрактный тип данных очередь
public class ArrayQueueADT {
    private ArrayQueueADT() {} // приватный конструктор

    // Тип "очередь" представлен объектом ArrayQueue
    public static void enqueue(ArrayQueue queue, Object item) {
        queue.enqueue(item);
    }

    public static Object element(ArrayQueue queue) {
        return queue.element();
    }

    public static Object dequeue(ArrayQueue queue) {
        return queue.dequeue();
    }

    public static int size(ArrayQueue queue) {
        return queue.size();
    }

    public static boolean isEmpty(ArrayQueue queue) {
        return queue.isEmpty();
    }

    public static void clear(ArrayQueue queue) {
        queue.clear();
    }
}
