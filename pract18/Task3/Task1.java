package pract18.Task3;

/*
public class Task1 {
    public void exceptionDemo() {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        String intString = myScanner.next();
        try {
            int i = Integer.parseInt(intString);
            System.out.println(2 / i);
        } catch (Exception e) {  // Общий обработчик
            System.out.println("General exception caught");
        } catch (ArithmeticException e) {  // Этот блок теперь никогда не выполнится
            System.out.println("Attempted division by zero");
        } catch (NumberFormatException e) {  // Этот тоже
            System.out.println("Invalid integer format");
        }
    }

    public static void main(String[] args) {
        Task1 ex = new Task1();
        ex.exceptionDemo();
    }
}
/*
Exception — родительский класс для ArithmeticException
Если catch (Exception) стоит первым, он перехватит все исключения
Блоки catch ниже него никогда не выполнятся это бессмысленно
Компилятор Java это обнаруживает и запрещает
 */