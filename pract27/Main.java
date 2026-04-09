public class Main {
    public static void main(String[] args) {

        System.out.println("Создание словаря:");
        Hashtab.hashtabInit();

        for (int i = 1; i <= 10; i++) {
            String key = "abc"+i;
            Hashtab.hashtabAdd("key" + i, "value" + i);
        }

        System.out.println("\nПоиск элемента:");
        String value = Hashtab.hashtabLookup("key5");
        System.out.println("key5 -> " + value);

        System.out.println("\nУдаление элемента:");
        Hashtab.hashtabDelete("key5");

        value = Hashtab.hashtabLookup("key5");
        System.out.println("key5 после удаления -> " + value);
    }
}
