import java.util.Scanner;
import java.util.Stack;

public class Task1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите элементы массива через пробел: ");

        String input = scanner.nextLine();
        String[] inputArray = input.split("\\s+");

        // Создаем массив из введенных чисел
        int[] array = new int[inputArray.length];
        for (int i = 0; i < inputArray.length; i++) {
            try {
                array[i] = Integer.parseInt(inputArray[i]);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введено не число: " + inputArray[i]);
                System.out.println("Используйте только целые числа!");
                scanner.close();
                return;
            }
        }

        System.out.print("\nИсходный массив: ");
        printArray(array);

        reverseArray(array);
        System.out.print("Инвертированный массив: ");
        printArray(array);

        reverseArray(array);

        scanner.close();
    }

    // Метод для инвертирования массива с использованием Stack
    public static void reverseArray(int[] array) {
        Stack<Integer> stack = new Stack<>();

        for (int element : array) {
            stack.push(element);
        }


        for (int i = 0; i < array.length; i++) {
            array[i] = stack.pop();
        }
    }

    private static void printArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}