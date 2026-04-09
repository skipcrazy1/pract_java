package pract18.Task1;

public class Task2 {
    public void exceptionDemo() {
        System.out.println(2.0 / 0.0);  // Infinity
    }

    public static void main(String[] args) {
        Task2 ex = new Task2();
        ex.exceptionDemo();
    }
}
/*
Здесь используется деление чисел с плавающей точкой
В стандарте IEEE 754 деление на ноль даёт
Infinity (положительная бесконечность) для положительного числа
-Infinity для отрицательного
NaN  для 0.0 / 0.0
 */