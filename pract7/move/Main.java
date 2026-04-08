package pract7.move;

public class Main {
    public static void main(String[] args) {

        Movable rect = new MovableRectangle(10, 5, 2);

        rect.moveUp();
        System.out.println("После moveUp:");
        System.out.println(rect);
    }
}



