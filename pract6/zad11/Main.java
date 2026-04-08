package pract6.zad11;

public class Main {
    public static void main(String[] args) {
        Celsius temp = new Celsius(25.0);

        System.out.println("Температура: " + temp.getCelsius() + " °C");
        System.out.println("В Кельвинах: " + temp.convert() + " K");
        System.out.println("В Фаренгейтах: " + temp.toFahrenheit() + " °F");
    }
}
