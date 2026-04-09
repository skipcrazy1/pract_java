package pract13;

public class Task5 {
    public static String formatPhoneNumber(String phone) {
        String digits = phone.replaceAll("[^0-9]", "");
        String countryCode;
        String number;

        if (phone.startsWith("+")) {
            countryCode = "+" + digits.substring(0, digits.length() - 10);
            number = digits.substring(digits.length() - 10);
        } else if (phone.startsWith("8") && digits.length() == 11) {
            countryCode = "+7";
            number = digits.substring(1);
        } else {
            return "Неверный формат";
        }

        return String.format("%s%s-%s-%s",
                countryCode,
                number.substring(0, 3),
                number.substring(3, 6),
                number.substring(6));
    }

    public static void main(String[] args) {
        String[] phones = {"+79175655655", "+104289652211", "89175655655"};
        for (String phone : phones) {
            System.out.println(phone + " -> " + formatPhoneNumber(phone));
        }
    }
}