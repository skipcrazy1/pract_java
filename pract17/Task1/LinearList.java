package pract17.Task1;

import java.util.Scanner;

// 3. Класс Тестер
public class LinearList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List list = new List();

        while (true) {
            System.out.println("\n1. Добавить");
            System.out.println("2. Удалить");
            System.out.println("3. Показать всех");
            System.out.println("4. Очистить");
            System.out.println("5. Проверить пустоту");
            System.out.println("0. Выход");
            System.out.print("Выбор: ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    Person node = new Person();
                    node.readFromConsole(sc);
                    list.add(node);
                    System.out.println("Добавлено!");
                    break;

                case 2:
                    System.out.print("Введите имя для удаления: ");
                    String name = sc.nextLine();
                    list.remove(name);
                    System.out.println("Удалено!");
                    break;

                case 3:
                    if (list.isEmpty()) {
                        System.out.println("Список пуст!");
                    } else {
                        list.printAll();
                    }
                    break;

                case 4:
                    list.clear();
                    System.out.println("Список очищен!");
                    break;

                case 5:
                    System.out.println(list.isEmpty() ? "Список пуст!" : "Список не пуст!");
                    break;

                case 0:
                    sc.close();
                    return;

                default:
                    System.out.println("Неверный выбор!");
            }
        }
    }
}
