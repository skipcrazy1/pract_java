package pract14;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Задание 3: Извлечение цен ===");
        System.out.println("Форматы: USD, RUB, EU");
        System.out.print("Введите текст с ценами: ");
        String text = scanner.nextLine();

        String regex = "\\b\\d+(\\.\\d+)?\\s*(USD|RUB|EU)\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        System.out.println("\nНайденные цены:");
        boolean found = false;
        while (matcher.find()) {
            System.out.println("• " + matcher.group());
            found = true;
        }

        if (!found) {
            System.out.println("Цены не найдены");
        }

        scanner.close();
    }
}