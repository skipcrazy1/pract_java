package pract11;

import java.util.*;
import java.text.SimpleDateFormat;

public class Task2 {
    public static void main(String[] args) throws Exception{
        Scanner scan = new Scanner(System.in);
        SimpleDateFormat form = new SimpleDateFormat("dd.MM.yyyy");
        System.out.println("Введите дату: (дд.мм.гггг)");
        Date userDate = form.parse(scan.nextLine());
        Date date = new Date();

        System.out.println("Введенная дата: " + form.format(userDate));
        System.out.println("Сегодня: " + form.format(date));

        if (userDate.before(date)){
            System.out.println("Это прошлая дата");
        }
        else if (userDate.after(date)){
            System.out.println("Это будущая дата");
        }
        else { System.out.println("Это сегодня"); }

        scan.close();
    }
}
