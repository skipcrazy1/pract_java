package pract17.Task3;

import java.util.Scanner;

class Person {
    String name;
    int age;
    Person next;

    void read(Scanner sc) {
        System.out.print("Имя: ");
        name = sc.nextLine();
        System.out.print("Возраст: ");
        age = Integer.parseInt(sc.nextLine());
    }

    void print() {
        System.out.println(name + ", " + age);
    }
}

