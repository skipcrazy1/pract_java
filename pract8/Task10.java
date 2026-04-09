package pract8;

import java.util.Scanner;

public class Task10 {
// Рекурсивный метод для переворота числа
public static int reverse(int n, int result) {

    if (n == 0) return result;

    return reverse(n / 10, result * 10 + (n % 10));
}

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(reverse(n, 0));
    }
}
