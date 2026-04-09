package pract8;

import java.util.Scanner;

public class Task17 {

    public static int findMax() {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();

        if (x == 0) return 0;

        int nextMax = findMax();
        return Math.max(x, nextMax);
    }

    public static void main(String[] args) {
        System.out.println(findMax());
    }
}
