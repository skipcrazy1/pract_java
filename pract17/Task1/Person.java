package pract17.Task1;

import java.util.Scanner;

// 1. Класс узла списка
class Person {
    String name;
    int age;
    Person next;

    void readFromConsole(Scanner sc) {
        System.out.print("Введите имя: ");
        name = sc.nextLine();
        System.out.print("Введите возраст: ");
        age = Integer.parseInt(sc.nextLine());
    }

    void printToConsole() {
        System.out.println("Имя: " + name + ", Возраст: " + age);
    }
}

