import java.util.LinkedList;

public class Hashtab {

    // Размер хеш-таблицы
    private static final int SIZE = 10;

    // Массив списков (метод цепочек)
    private static LinkedList<HashEntry>[] table;

    // Элемент хеш-таблицы
    static class HashEntry {
        String key;
        String value;

        HashEntry(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void hashtabInit() {
        table = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            table[i] = new LinkedList<>();
        }
    }

    public static int hashtabHash(String key) {
        return Math.abs(key.hashCode()) % SIZE;
    }

    public static void hashtabAdd(String key, String value) {
        int index = hashtabHash(key);

        for (HashEntry entry : table[index]) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }

        table[index].add(new HashEntry(key, value));
    }

    public static String hashtabLookup(String key) {
        int index = hashtabHash(key);

        for (HashEntry entry : table[index]) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }

    public static boolean hashtabDelete(String key) {
        int index = hashtabHash(key);

        for (HashEntry entry : table[index]) {
            if (entry.key.equals(key)) {
                table[index].remove(entry);
                return true;
            }
        }
        return false;
    }
    public static void hashtabPrint() {
        System.out.println("\nСодержимое хеш-таблицы:");
        for (int i = 0; i < SIZE; i++) {
            System.out.print("[" + i + "] ");

            if (table[i].isEmpty()) {
                System.out.println("empty");
            } else {
                for (HashEntry entry : table[i]) {
                    System.out.print("{" + entry.key + " : " + entry.value + "} ");
                }
                System.out.println();
            }
        }
    }
}
