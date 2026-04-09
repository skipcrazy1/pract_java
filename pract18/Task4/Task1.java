package pract18.Task4;

import java.util.Scanner;

public class Task1 {
    public void exceptionDemo() {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("введите целочисленное число: ");
        String intString = myScanner.next();
        try {
            int i = Integer.parseInt(intString);
            System.out.println(2 / i);
        } catch (ArithmeticException e) {
            System.out.println("деление на ноль!");
        } catch (NumberFormatException e) {
            System.out.println("Некорректный формат");
        } finally {
            System.out.println("финальный блок произошел");
        }
    }

    public static void main(String[] args) {
        Task1 ex = new Task1();
        ex.exceptionDemo();
    }
}
/*
Если исключения нет выполняется try, затем finally.
Если исключение есть и перехвачено try прерывается, выполняется catch, затем finally.
Если исключение есть и не перехвачено try прерывается, затем finally, затем программа ломается.
Зачем нужен finally: для гарантированного выполнения кода (например, закрытие файлов, освобождение ресурсов)
 */