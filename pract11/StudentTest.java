package pract11;

import java.util.Date;

public class StudentTest {
    public static void main(String[] args) {
        Student s = new Student("Эмиль", new Date(104, 5, 15));

        System.out.println("Коротко: " + s.getBirthDate("short"));
        System.out.println("Полно: " + s.getBirthDate("full"));
        System.out.println(s);
    }
}
