package pract3.format;

import java.util.Scanner;

public class Format {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Converter converter = new Converter();

        System.out.print("Введите сумму в USD: ");
        double usdAmount = scanner.nextDouble();

        converter.convert(usdAmount);
        System.out.println(converter);

    }
}
