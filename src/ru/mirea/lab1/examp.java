package ru.mirea.lab1;
import java.util.ArrayList;
import java.util.Scanner;

public class examp {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("введите размер массива: ");
        int size = scanner.nextInt();
        int sum = 0;
        int c = 0;
        double avg = 0.0;
        ArrayList<Integer> lst = new ArrayList<>();
        System.out.println("Введите значения массива: ");
        for (int i=0; i < size; i++)
        {
            int n = scanner.nextInt();
            lst.add(n);
            sum += n;
            c ++;
        }
        avg = sum/c;
        System.out.println(lst);
        System.out.println("сумма: "+ sum + "\n" + "Ср Арифм: " + avg);
    }
}
