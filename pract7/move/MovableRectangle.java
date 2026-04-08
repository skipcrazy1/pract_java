package pract7.move;

public class MovableRectangle implements Movable {

    private int x, y;
    private int speed;

    public MovableRectangle(int x, int y, int speed) {
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    @Override
    public void moveUp() { y -= speed; }

    @Override
    public void moveDown() { y += speed; }

    @Override
    public void moveLeft() { x -= speed; }

    @Override
    public void moveRight() { x += speed; }

    @Override
    public String toString() {
        return "Rectangle at (" + x + ", " + y + ")";
    }
}