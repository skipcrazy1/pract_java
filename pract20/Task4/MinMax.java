package pract20.Task4;

import java.util.Arrays;

class MinMax<T extends Comparable<T>> {
    private T[] array;

    // Конструктор принимает массив
    public MinMax(T[] array) {
        this.array = array;
    }

    // Метод для нахождения минимального элемента
    public T findMin() {
        if (array == null || array.length == 0) {
            return null;
        }

        T min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i].compareTo(min) < 0) {
                min = array[i];
            }
        }
        return min;
    }

    // Метод для нахождения максимального элемента
    public T findMax() {
        if (array == null || array.length == 0) {
            return null;
        }

        T max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i].compareTo(max) > 0) {
                max = array[i];
            }
        }
        return max;
    }

    // Метод для вывода массива
    public void printArray() {
        System.out.println(Arrays.toString(array));
    }
}
