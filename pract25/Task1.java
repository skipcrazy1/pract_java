package pract25;

import java.util.Scanner;
import java.util.regex.*;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== ПРИЛОЖЕНИЕ ДЛЯ РАБОТЫ СО СТРОКАМИ ===\n");

        System.out.print("Введите строку: ");
        String input = scanner.nextLine();

        System.out.println("\nВыберите действие:");
        System.out.println("1. Разбить на слова");
        System.out.println("2. Найти числа");
        System.out.println("3. Найти email");
        System.out.println("4. Найти даты dd/mm/yyyy");
        System.out.println("5. Удалить пробелы");
        System.out.println("6. Найти спецсимволы");
        System.out.print("> ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1: splitWords(input); break;
            case 2: findNumbers(input); break;
            case 3: findEmails(input); break;
            case 4: findDates(input); break;
            case 5: removeSpaces(input); break;
            case 6: findSpecialChars(input); break;
            default: System.out.println("Неверный выбор");
        }
        scanner.close();
    }

    private static void splitWords(String text) {
        System.out.println("\nСлова:");
        String[] words = text.split("[^a-zA-Zа-яА-ЯёЁ]+");
        for (String w : words) if (!w.isEmpty()) System.out.println("- " + w);
    }

    private static void findNumbers(String text) {
        System.out.println("\nЧисла:");
        Matcher m = Pattern.compile("\\d+(\\.\\d+)?").matcher(text);
        while (m.find()) System.out.println("- " + m.group());
    }

    private static void findEmails(String text) {
        System.out.println("\nEmail:");
        Matcher m = Pattern.compile("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}").matcher(text);
        while (m.find()) System.out.println("- " + m.group());
    }

    private static void findDates(String text) {
        System.out.println("\nДаты:");
        Matcher m = Pattern.compile("(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/(19|20)\\d{2}").matcher(text);
        while (m.find()) System.out.println("- " + m.group());
    }

    private static void removeSpaces(String text) {
        System.out.println("\nБез пробелов: \"" + text.replaceAll("\\s+", " ").trim() + "\"");
    }

    private static void findSpecialChars(String text) {
        System.out.println("\nСпецсимволы:");
        Matcher m = Pattern.compile("[^a-zA-Z0-9\\sа-яА-ЯёЁ]").matcher(text);
        while (m.find()) System.out.println("- '" + m.group() + "'");
    }
}