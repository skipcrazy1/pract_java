package pract17.Task3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RingList list = new RingList();

        while (true) {
            System.out.println("\n1. Добавить\n2. Удалить\n3. Показать\n4. Очистить\n5. Пусто?\n0. Выход");
            System.out.print("> ");
            int c = Integer.parseInt(sc.nextLine());

            switch (c) {
                case 1:
                    Person n = new Person();
                    n.read(sc);
                    list.add(n);
                    System.out.println("Добавлено");
                    break;
                case 2:
                    System.out.print("Имя: ");
                    list.remove(sc.nextLine());
                    System.out.println("Удалено");
                    break;
                case 3:
                    list.show();
                    break;
                case 4:
                    list.clear();
                    System.out.println("Очищено");
                    break;
                case 5:
                    System.out.println(list.isEmpty() ? "Пусто" : "Не пусто");
                    break;
                case 0:
                    sc.close();
                    return;
                default:
                    System.out.println("Неверно");
            }
        }
    }
}
