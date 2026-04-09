package pract18.Task2;

import java.util.Scanner;

public class Task2 {
    public void exceptionDemo() {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        String intString = myScanner.next();
        try {
            int i = Integer.parseInt(intString);
            System.out.println(2 / i);
        } catch (ArithmeticException e) {
            System.out.println("Attempted division by zero");
        } catch (NumberFormatException e) {
            System.out.println("Invalid integer format");
        }
    }

    public static void main(String[] args) {
        Task2 ex = new Task2();
        ex.exceptionDemo();
    }
}
/*
Qwerty  "Invalid integer format"
0  "Attempted division by zero"
2.4   "Invalid integer format"
1  выводится 2
 */