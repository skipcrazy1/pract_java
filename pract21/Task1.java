package pract21;

import java.util.*;

public class Task1 {
    public static <T> List<T> arrayToList(T[] array) {
        return new ArrayList<>(Arrays.asList(array));
    }

    public static void main(String[] args) {
        String[] strings = {"Hello", "World", "Java"};
        Integer[] numbers = {1, 2, 3, 4, 5};

        System.out.println("Список строк: " + arrayToList(strings));
        System.out.println("Список чисел: " + arrayToList(numbers));
    }
}