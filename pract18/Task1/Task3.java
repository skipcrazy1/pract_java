package pract18.Task1;

public class Task3 {
    public void exceptionDemo() {
        try {
            System.out.println(2 / 0);
        } catch (ArithmeticException e) {
            System.out.println("Attempted division by zero");
        }
    }

    public static void main(String[] args) {
        Task3 ex = new Task3();
        ex.exceptionDemo();
    }
}

/*
Код внутри try выполняется
При делении на ноль возникает ArithmeticException
Выполнение кода в блоке try немедленно прекращается
Управление передаётся в блок catch, который соответствует типу исключения
Выполняется код внутри catch, выводится сообщение
 */