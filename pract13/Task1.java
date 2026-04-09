package pract13;

import java.util.*;

public class Task1 {
    public static void main(String[] args) {
        String str = "I like Java!!";

        // 1. Последний символ
        System.out.println("Последний символ: " + str.charAt(str.length() - 1));

        // 2. Заканчивается на "!!!"?
        System.out.println("Заканчивается на '!!!'? " + str.endsWith("!!!"));

        // 3. Начинается на "I like"?
        System.out.println("Начинается на 'I like'? " + str.startsWith("I like"));

        // 4. Содержит "Java"?
        System.out.println("Содержит 'Java'? " + str.contains("Java"));

        // 5. Позиция "Java"
        System.out.println("Позиция 'Java': " + str.indexOf("Java"));

        // 6. Замена 'a' на 'o'
        System.out.println("Замена 'a' на 'o': " + str.replace('a', 'o'));

        // 7. Верхний регистр
        System.out.println("Верхний регистр: " + str.toUpperCase());

        // 8. Нижний регистр
        System.out.println("Нижний регистр: " + str.toLowerCase());

        // 9. Вырезать "Java"
        int start = str.indexOf("Java");
        int end = start + "Java".length();
        System.out.println("Вырезано 'Java': " + str.substring(start, end));
    }
}