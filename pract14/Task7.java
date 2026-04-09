package pract14;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Task7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Задание 7: Проверка пароля ===");
        System.out.println("Требования:");
        System.out.println("- Не менее 8 символов");
        System.out.println("- Только буквы, цифры и подчёркивание");
        System.out.println("- Хотя бы одна заглавная буква");
        System.out.println("- Хотя бы одна строчная буква");
        System.out.println("- Хотя бы одна цифра");
        System.out.print("Введите пароль: ");
        String password = scanner.nextLine();

        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d_]{8,}$";
        boolean matches = Pattern.matches(regex, password);

        System.out.println("Результат: " + (matches ? "надёжный пароль" : "ненадёжный пароль"));

        scanner.close();
    }
}