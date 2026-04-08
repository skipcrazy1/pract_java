package pract2.zad2;

public class TestBall {
    public static void main(String[] args)
    {
        Ball ball = new Ball(0, 0);
        System.out.println(ball);
        ball.setX(3);
        ball.setY(5);
        System.out.println(ball);
        ball.setXY(5, 2);
        System.out.println(ball);
        ball.move(2, 3);
        System.out.println(ball);
    }
}
