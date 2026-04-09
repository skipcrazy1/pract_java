import java.util.HashMap;
import java.util.Map;

public class Task2 {

    //создание Map
    public static Map<String, String> createMap() {
        Map<String, String> map = new HashMap<>();

        map.put("Иванов", "Алексей");
        map.put("Петров", "Иван");
        map.put("Сидоров", "Алексей");
        map.put("Смирнов", "Дмитрий");
        map.put("Кузнецов", "Иван");
        map.put("Попов", "Алексей");
        map.put("Васильев", "Максим");
        map.put("Морозов", "Иван");
        map.put("Новиков", "Максим");
        map.put("Федоров", "Алексей");

        return map;
    }

    //количество людей с одинаковыми именами
    public static int getSameFirstNameCount(Map<String, String> map) {
        int count = 0;

        for (String name1 : map.values()) {
            for (String name2 : map.values()) {
                if (name1.equals(name2)) {
                    count++;
                }
            }
            count--; // не считаем самого себя
        }
        return count / 2;
    }

    //количество людей с одинаковыми фамилиями
    public static int getSameLastNameCount(Map<String, String> map) {
        int count = 0;

        for (String lastName1 : map.keySet()) {
            for (String lastName2 : map.keySet()) {
                if (lastName1.equals(lastName2)) {
                    count++;
                }
            }
            count--;
        }
        return count / 2;
    }
}
