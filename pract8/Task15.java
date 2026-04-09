package pract8;

import java.util.Scanner;

public class Task15 {

//    public static void printDigitsRight(int n) {
//        System.out.print((n % 10) + " ");
//        if (n < 10) return;
//        printDigitsRight(n / 10);
//    }

    public static int factorial(int n) {
        int f = n;
        if (n == 1) return 1;
        return f*factorial(n-1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
//        printDigitsRight(n);
        System.out.println(factorial(n));
    }
}
