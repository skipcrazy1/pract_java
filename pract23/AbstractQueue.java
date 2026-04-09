package pract23;

//Абстрактный базовый класс для всех реализаций очереди

public abstract class AbstractQueue implements Queue {
    protected int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    // Базовая реализация toString для всех очередей
    @Override
    public String toString() {
        return "Очередь[размер=" + size + "]";
    }
}