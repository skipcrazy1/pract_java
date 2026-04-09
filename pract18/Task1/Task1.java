package pract18.Task1;

public class Task1 {
    public void exceptionDemo() {
        System.out.println(2 / 0);
    }

    public static void main(String[] args) {
        Task1 ex = new Task1();
        ex.exceptionDemo();
    }
}


/*
Программа пытается выполнить целочисленное деление 2 / 0
В математике деление на ноль не определено
Java выбрасывает исключение ArithmeticException
Программа аварийно завершается, потому что исключение не обрабатывается
 */