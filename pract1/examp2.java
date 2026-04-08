package practica1;
import java.util.ArrayList;
import java.util.Scanner;

public class examp2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("введите размер массива: ");
        int size = scanner.nextInt();
        double[] lst = new double[size];
        int ind= 0;
        while (ind < size) {
            System.out.print("Введите элемент № " + (ind + 1) + ": ");
            lst[ind] = scanner.nextDouble();
            ind++;
        }

        double sum = 0;
        double max = lst[0];
        double min = lst[0];
        int i = 0;

        do {
            sum += lst[i];
            if (lst[i] > max) {
                max = lst[i];
            }
            if (lst[i] < min) {
                min = lst[i];
            }
            i++;
        } while (i < size);

        System.out.println("Сумма элементов массива: " + sum);
        System.out.println("Максимальный элемент: " + max);
        System.out.println("Минимальный элемент: " + min);
    }
}
