package pract17.Task2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DoubleList list = new DoubleList();

        while (true) {
            System.out.println("\n1. Добавить\n2. Удалить\n3. Прямой показ\n4. Обратный показ\n5. Очистить\n6. Пусто?\n0. Выход");
            System.out.print("> ");
            int c = Integer.parseInt(sc.nextLine());

            switch (c) {
                case 1:
                    pract17.Task2.Person n = new pract17.Task2.Person();
                    n.read(sc);
                    list.add(n);
                    break;
                case 2:
                    System.out.print("Имя: ");
                    list.remove(sc.nextLine());
                    break;
                case 3:
                    if (list.isEmpty()) System.out.println("Пусто");
                    else list.showForward();
                    break;
                case 4:
                    if (list.isEmpty()) System.out.println("Пусто");
                    else list.showBackward();
                    break;
                case 5:
                    list.clear();
                    System.out.println("Очищено");
                    break;
                case 6:
                    System.out.println(list.isEmpty() ? "Пусто" : "Не пусто");
                    break;
                case 0:
                    sc.close();
                    return;
            }
        }
    }
}