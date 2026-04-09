package pract20.Task123;

// Задание 3: Класс с ограничениями на параметры типа
class ConstrainedTriple<T extends Comparable<T>, V extends Animal> {
    private T first;
    private V second;

    public ConstrainedTriple(T first, V second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public V getSecond() {
        return second;
    }


    // Метод, использующий Comparable
    public boolean isFirstGreaterThan(T other) {
        return first.compareTo(other) > 0;
    }
}
