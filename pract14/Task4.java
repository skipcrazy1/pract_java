package pract14;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Задание 4: Цифры без знака + ===");
        System.out.print("Введите математическое выражение: ");
        String input = scanner.nextLine();

        String regex = "\\d(?!\\s*\\+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        System.out.println("\nРезультат:");
        if (matcher.find()) {
            System.out.println("В тексте ЕСТЬ цифры, за которыми не стоит знак '+'");
            System.out.println("Первое совпадение на позиции: " + matcher.start());
        } else {
            System.out.println("В тексте НЕТ цифр без знака '+' после них");
        }

        scanner.close();
    }
}
