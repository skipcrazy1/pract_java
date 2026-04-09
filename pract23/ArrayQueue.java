package pract23;

import java.util.Arrays;

public class ArrayQueue extends AbstractQueue {
    private Object[] elements;
    private int front = 0;
    private int rear = 0;
    private final int capacity;
    // Предусловие: capacity > 0
    // Постусловие: создана пустая очередь заданной вместимости
    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        this.elements = new Object[capacity];
    }
    // Предусловие: очередь не пуста
    // Постусловие: возвращает первый элемент без удаления
    @Override
    public Object element() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return elements[front];
    }
    // Предусловие: size < capacity
    // Постусловие: элемент добавлен в конец очереди, size увеличивается на 1
    @Override
    public void enqueue(Object item) {
        if (size == capacity) {
            throw new IllegalStateException("Queue is full");
        }
        elements[rear] = item;
        rear = (rear + 1) % capacity;
        size++;
    }

    @Override
    public Object dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        Object item = elements[front];
        elements[front] = null;
        front = (front + 1) % capacity;
        size--;
        return item;
    }

    @Override
    public void clear() {
        Arrays.fill(elements, null);
        front = 0;
        rear = 0;
        size = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % capacity;
            sb.append(elements[index]);
            if (i < size - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}