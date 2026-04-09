//package pract20.Task4;
//
//public class Test4 {
//    public static void main(String[] args){
//        Integer[] intArray = {5, 2, 8, 1, 9, 3};
//        MinMax<Integer> intMinMax = new MinMax<>(intArray);
//
//        System.out.print("Массив: ");
//        intMinMax.printArray();
//        System.out.println("Минимальный: " + intMinMax.findMin());
//        System.out.println("Максимальный: " + intMinMax.findMax());
//
//        // Тестируем MinMax с String
//        String[] strArray = {"apple", "zebra", "banana", "cherry"};
//        MinMax<String> strMinMax = new MinMax<>(strArray);
//
//        System.out.print("\nМассив строк: ");
//        strMinMax.printArray();
//        System.out.println("Минимальный: " + strMinMax.findMin());
//        System.out.println("Максимальный: " + strMinMax.findMax());
//
//
//        // Тестируем Calculator
//        Integer a = 10;
//        Double b = 3.5;
//
//        System.out.println("Сумма " + a + " + " + b + " = " + Calculator.sum(a, b));
//        System.out.println("Умножение " + a + " * " + b + " = " + Calculator.multiply(a, b));
//        System.out.println("Деление " + a + " / " + b + " = " + Calculator.divide(a, b));
//        System.out.println("Вычитание " + a + " - " + b + " = " + Calculator.subtract(a, b));
//
//        // Другие типы
//        Float f = 7.2f;
//        Long l = 15L;
//    }
//}

package pract20.Task4;

import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Тестирование MinMax для целых чисел");
        System.out.print("Введите количество целых чисел: ");
        int intCount = scanner.nextInt();
        Integer[] intArray = new Integer[intCount];

        System.out.println("Введите " + intCount + " целых чисел:");
        for (int i = 0; i < intCount; i++) {
            System.out.print("Число " + (i + 1) + ": ");
            intArray[i] = scanner.nextInt();
        }

        MinMax<Integer> intMinMax = new MinMax<>(intArray);

        System.out.print("\nВведенный массив целых чисел: ");
        intMinMax.printArray();
        System.out.println("Минимальный: " + intMinMax.findMin());
        System.out.println("Максимальный: " + intMinMax.findMax());

        System.out.println("\nТестирование MinMax для строк ");
        scanner.nextLine(); // Очистка буфера

        System.out.print("Введите количество строк: ");
        int strCount = scanner.nextInt();
        scanner.nextLine(); // Очистка буфера

        String[] strArray = new String[strCount];

        System.out.println("Введите " + strCount + " строк:");
        for (int i = 0; i < strCount; i++) {
            System.out.print("Строка " + (i + 1) + ": ");
            strArray[i] = scanner.nextLine();
        }

        MinMax<String> strMinMax = new MinMax<>(strArray);

        System.out.print("\nВведенный массив строк: ");
        strMinMax.printArray();
        System.out.println("Минимальный: " + strMinMax.findMin());
        System.out.println("Максимальный: " + strMinMax.findMax());

        System.out.println("\nТестирование Calculator");

        System.out.println("Введите два числа для операций (будут преобразованы к разным типам):");

        System.out.print("Первое число: ");
        double num1 = scanner.nextDouble();
        System.out.print("Второе число: ");
        double num2 = scanner.nextDouble();

        Integer a = (int) num1;
        Double b = num2;
        Float f = (float) num1;
        Long l = (long) num2;

        System.out.println("\nТестирование с Integer и Double:");
        System.out.println("Сумма " + a + " + " + b + " = " + Calculator.sum(a, b));
        System.out.println("Умножение " + a + " * " + b + " = " + Calculator.multiply(a, b));
        System.out.println("Деление " + a + " / " + b + " = " + Calculator.divide(a, b));
        System.out.println("Вычитание " + a + " - " + b + " = " + Calculator.subtract(a, b));

        System.out.println("\nТестирование с Float и Long:");
        System.out.println("Сумма " + f + " + " + l + " = " + Calculator.sum(f, l));
        System.out.println("Умножение " + f + " * " + l + " = " + Calculator.multiply(f, l));
        System.out.println("Деление " + f + " / " + l + " = " + Calculator.divide(f, l));
        System.out.println("Вычитание " + f + " - " + l + " = " + Calculator.subtract(f, l));

        scanner.close();
    }
}