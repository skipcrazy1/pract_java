package pract14;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Задание 5: Проверка даты ===");
        System.out.println("Формат: dd/mm/yyyy (1900-9999)");
        System.out.print("Введите дату: ");
        String date = scanner.nextLine();

        String regex = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/(19|[2-9][0-9])\\d{2}$";
        boolean matches = Pattern.matches(regex, date);

        System.out.println("Результат: " + (matches ? "корректная дата" : "некорректная дата"));

        scanner.close();
    }
}