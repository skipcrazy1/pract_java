package pract11;

import java.util.*;

public class Task4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите год месяц день: ");
        int year = sc.nextInt();
        int month = sc.nextInt();
        int day = sc.nextInt();

        System.out.println("Введите часы минуты: ");
        int hour = sc.nextInt();
        int minute = sc.nextInt();

        Date date1 = new Date(year-1900, month-1, day, hour, minute);

        Calendar cal = Calendar.getInstance();
        cal.set(year, month-1, day, hour, minute, 0);
        Date date2 = cal.getTime();

        System.out.println("Date: " + date1);
        System.out.println("Calendar: " + date2);

        sc.close();
    }

}
