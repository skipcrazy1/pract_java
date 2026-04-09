package pract23;

public class QueueTest {
    public static void main(String[] args) {
        System.out.println("\nArrayQueue");
        testQueue(new ArrayQueue(5));

        System.out.println("\nArrayQueueModule");
        testQueueModule();

        System.out.println("\nArrayQueueADT");
        ArrayQueue queueADT = new ArrayQueue(5);
        testQueueADT(queueADT);

        System.out.println("\nLinkedQueue");
        testQueue(new LinkedQueue());
    }

    private static void testQueue(Queue queue) {
        // Тест добавления
        System.out.println("Добавляем элементы: 1, 2, 3");
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println("Очередь: " + queue);
        System.out.println("Размер: " + queue.size());

        // Тест element()
        System.out.println("Первый элемент: " + queue.element());

        // Тест dequeue()
        System.out.println("Удаляем первый элемент: " + queue.dequeue());
        System.out.println("Очередь после удаления: " + queue);

        // Тест isEmpty() и clear()
        queue.clear();
        System.out.println("Очистили очередь. Пуста? " + queue.isEmpty());

        // Тест исключений
        try {
            queue.dequeue();
        } catch (IllegalStateException e) {
            System.out.println("Поймано исключение (ожидаемо): " + e.getMessage());
        }
    }

    private static void testQueueModule() {
        ArrayQueueModule.clear();

        ArrayQueueModule.enqueue("A");
        ArrayQueueModule.enqueue("B");
        ArrayQueueModule.enqueue("C");

        System.out.println("Очередь: " + ArrayQueueModule.toStringQueue());
        System.out.println("Первый элемент: " + ArrayQueueModule.element());
        System.out.println("Удаляем: " + ArrayQueueModule.dequeue());
        System.out.println("Размер после удаления: " + ArrayQueueModule.size());
    }

    private static void testQueueADT(ArrayQueue queue) {
        ArrayQueueADT.clear(queue);

        ArrayQueueADT.enqueue(queue, "X");
        ArrayQueueADT.enqueue(queue, "Y");
        ArrayQueueADT.enqueue(queue, "Z");

        System.out.println("Очередь: " + queue);
        System.out.println("Первый элемент: " + ArrayQueueADT.element(queue));
        System.out.println("Удаляем: " + ArrayQueueADT.dequeue(queue));
        System.out.println("Размер: " + ArrayQueueADT.size(queue));
    }
}