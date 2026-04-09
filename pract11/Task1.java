package pract11;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Task1 {
    public static void main(String[] args) {
        SimpleDateFormat form = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        System.out.println("Разработчик: Галиев");
        System.out.println("Задание получено: " + form.format(new Date()));

        // Имитация работы
        try { Thread.sleep(5000); } catch (Exception e) {}

        System.out.println("Задание сдано: " + form.format(new Date()));
    }
}
