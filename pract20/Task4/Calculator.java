package pract20.Task4;

class Calculator {

    // Сумма двух чисел разного типа
    public static <T extends Number, V extends Number> double sum(T a, V b) {
        return a.doubleValue() + b.doubleValue();
    }

    // Умножение двух чисел разного типа
    public static <T extends Number, V extends Number> double multiply(T a, V b) {
        return a.doubleValue() * b.doubleValue();
    }

    // Деление двух чисел разного типа
    public static <T extends Number, V extends Number> double divide(T a, V b) {
        if (b.doubleValue() == 0) {
            throw new ArithmeticException("Деление на ноль!");
        }
        return a.doubleValue() / b.doubleValue();
    }

    // Вычитание двух чисел разного типа
    public static <T extends Number, V extends Number> double subtract(T a, V b) {
        return a.doubleValue() - b.doubleValue();
    }
}