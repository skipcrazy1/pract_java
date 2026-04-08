package practica1;
import java.util.Scanner;
import java.lang.Math;

public class examp4 {
    public static void main(String[] args) {
        for (int n = 1; n <= 10; n++) {
            double harmonicNumber = 0.0;

            // Вычисляем n-ное число гармонического ряда
            for (int i = 1; i <= n; i++) {
                harmonicNumber = 1.0 / i;
            }
            System.out.printf("%.3f%n" ,harmonicNumber);

        }
    }
}
