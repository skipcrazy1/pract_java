package pract7.string;

public class teststring {
    public static void main(String[] args) {

        StringOperations ps = new ProcessStrings();

        String s = "HelloWorld";

        System.out.println("Строка: " + s);
        System.out.println("Количество символов: " + ps.countChars(s));

        // --- Тест 2: символы на нечетных позициях (0, 2, 4...) ---
        System.out.println("Символы на нечётных позициях: " + ps.oddPositions(s));

        // --- Тест 3: перевёрнутая строка ---
        System.out.println("Перевёрнутая строка: " + ps.invert(s));
    }
}
