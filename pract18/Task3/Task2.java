package pract18.Task3;

import java.util.Scanner;

public class Task2 {
    public void exceptionDemo() {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        String intString = myScanner.next();
        try {
            int i = Integer.parseInt(intString);
            System.out.println(2 / i);
        } catch (ArithmeticException e) {
            System.out.println("Attempted division by zero");
        } catch (NumberFormatException e) {
            System.out.println("Invalid integer format");
        } catch (Exception e) {  // Общий обработчик — последним
            System.out.println("General exception caught");
        }
    }

    public static void main(String[] args) {
        Task2 ex = new Task2();
        ex.exceptionDemo();
    }
}
/*
Java проверяет исключение по порядку сверху вниз
Если тип исключения совпадает с типом в catch — выполняется этот блок
Если нет — проверяется следующий
catch (Exception e) ловит всё остальное, что не поймали выше
общий catch — это «страховка» на случай непредвиденных исключений
 */