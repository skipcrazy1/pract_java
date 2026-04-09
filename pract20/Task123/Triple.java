package pract20.Task123;

// Задание 1-2: Обобщенный класс с тремя параметрами
class Triple<T, V, K> {
    private T first;
    private V second;
    private K third;

    // Конструктор
    public Triple(T first, V second, K third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    // Геттеры
    public T getFirst() {
        return first;
    }

    public V getSecond() {
        return second;
    }

    public K getThird() {
        return third;
    }

    // Метод для вывода имен классов
    public void printClassNames() {
        System.out.println("Тип T: " + first.getClass().getName());
        System.out.println("Тип V: " + second.getClass().getName());
        System.out.println("Тип K: " + third.getClass().getName());
    }

    @Override
    public String toString() {
        return "Triple{" + first + ", " + second + ", " + third + "}";
    }
}

