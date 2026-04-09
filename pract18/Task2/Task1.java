package pract18.Task2;

import java.util.Scanner;

public class Task1 {
    public void exceptionDemo() {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        String intString = myScanner.next();
        int i = Integer.parseInt(intString);
        System.out.println(2 / i);
    }

    public static void main(String[] args) {
        Task1 ex = new Task1();
        ex.exceptionDemo();
    }
}
/*
Qwerty	Integer.parseInt() не может преобразовать строку → NumberFormatException
0	Деление 2 / 0 → ArithmeticException
2.4	Integer.parseInt() не принимает точку → NumberFormatException
1	Успешное выполнение → выводится 2
 */