package pract25;

public class Task4 {
    public static void main(String[] args) {
        String[] testEmails = {
                "user@example.com",    // правильный
                "root@localhost",      // правильный
                "myhost@@com.ru",      // неправильный
                "@my.ru",              // неправильный
                "Julia String"         // неправильный
        };

        // Регулярное выражение по RFC 2822 (упрощенное)
        String rfc2822 = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

        System.out.println("Проверка email по RFC 2822:");
        for (String email : testEmails) {
            boolean isValid = email.matches(rfc2822);
            System.out.println(email + " " + (isValid ? "корректный" : "некорректный"));
        }
    }
}