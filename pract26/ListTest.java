import java.util.Iterator;

public class ListTest {
    public static void main(String[] args) {
        List<String> fruits = new MyList<>();

        System.out.println("Добавляем элементы в список:");
        fruits.add("Яблоко");
        fruits.add("Банан");
        fruits.add("Апельсин");
        fruits.add("Груша");

        System.out.println("   Список: " + fruits);
        System.out.println("   Размер: " + fruits.size());

        System.out.println("\nПолучаем элементы по индексу:");
        System.out.println("   fruits.get(0) = " + fruits.get(0));
        System.out.println("   fruits.get(2) = " + fruits.get(2));

        System.out.println("\nИспользуем итератор:");
        Iterator<String> iterator = fruits.iterator();
        System.out.print("   Элементы через итератор: ");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        System.out.println("\nИспользуем for-each цикл:");
        System.out.print("   Элементы через for-each: ");
        for (String fruit : fruits) {
            System.out.print(fruit + " ");
        }
        System.out.println();

        System.out.println("\nТест со списком чисел:");
        List<Integer> numbers = new MyList<>();

        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);
        numbers.add(50);

        System.out.print("   Числа через for-each: ");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println("\n   Список чисел: " + numbers);

        System.out.println("\nПроверка увеличения массива:");
        List<Integer> bigList = new MyList<>();
        System.out.print("   Добавляем 15 чисел: ");
        for (int i = 1; i <= 15; i++) {
            bigList.add(i * 10);
        }
        System.out.println(bigList);
        System.out.println("   Размер: " + bigList.size());
    }
}