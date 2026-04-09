package pract19.Task1;

import java.util.Scanner;

class InvalidInnException extends Exception {
    public InvalidInnException(String message) {
        super(message);
    }
}

final class InnValidator {
    private InnValidator() {}

    public static void validate(String inn) throws InvalidInnException {
        if (inn == null) throw new InvalidInnException("ИНН не задан.");
        String digits = inn.replaceAll("\\D", ""); // разрешим ввод с дефисами/пробелами
        if (!(digits.length() == 10 || digits.length() == 12)) {
            throw new InvalidInnException("ИНН должен содержать 10 или 12 цифр.");
        }
        if (!digits.chars().allMatch(Character::isDigit)) {
            throw new InvalidInnException("ИНН должен содержать только цифры.");
        }

        if (digits.length() == 10) {
            int check = calcControl(digits, new int[]{2,4,10,3,5,9,4,6,8}, 9);
            int last = digits.charAt(9) - '0';
            if (check != last) throw new InvalidInnException("Недействительный ИНН (контрольная цифра).");
        } else {
            int c11 = calcControl(digits, new int[]{7,2,4,10,3,5,9,4,6,8}, 10);
            int c12 = calcControl(digits, new int[]{3,7,2,4,10,3,5,9,4,6,8}, 11);
            int d11 = digits.charAt(10) - '0';
            int d12 = digits.charAt(11) - '0';
            if (c11 != d11 && c12 != d12) {
                throw new InvalidInnException("Недействительный ИНН (контрольные цифры).");
            }
        }
    }

    // Алгоритм: сумма(d[i]*w[i]) % 11, затем берём младший разряд (по сути %10). [web:18]
    private static int calcControl(String digits, int[] weights, int countDigits) {
        int sum = 0;
        for (int i = 0; i < countDigits; i++) {
            sum += (digits.charAt(i) - '0') * weights[i];
        }
        int mod11 = sum % 11;
        return mod11 % 10; // “младший разряд” остатка [web:18]
    }
}

public class Task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите ФИО: ");
        String fio = sc.nextLine().trim();

        // 3730983711 корректный инн из генератора инн
        System.out.print("Введите ИНН: ");
        String inn = sc.nextLine().trim();

        try {
            InnValidator.validate(inn);
            System.out.println("Заказ оформлен. ФИО: " + fio + ", ИНН валиден.");
        } catch (InvalidInnException e) {
            System.out.println("Ошибка оформления: " + e.getMessage());
        }
    }
}