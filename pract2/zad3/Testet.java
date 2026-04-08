package pract2.zad3;

import java.util.Scanner;

public class Testet {
    private Circle[] circles;
    private int count;

    public Testet(int capacity) {
        circles = new Circle[capacity];
        count = 0;
    }

    public void addCircle(Circle circle) {
        if (count < circles.length) {
            circles[count] = circle;
            count++;
        }
    }

    public void printTester() {
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ")" + " " + circles[i]);
        }
    }

    public static void main(String[] args) {
        System.out.println("Введите размер массива");
        Scanner scanner = new Scanner(System.in);
        int capacity = scanner.nextInt();
        Testet test = new Testet(capacity);
        for (int i = 0; i < capacity; i++) {
            System.out.println("Введите координаты окружности и её радиус");
            Point point = new Point(0, 0);
            point.setX(scanner.nextDouble());
            point.setY(scanner.nextDouble());
            Circle circle = new Circle(point, scanner.nextDouble());
            test.addCircle(circle);
        }
        test.printTester();
    }
}