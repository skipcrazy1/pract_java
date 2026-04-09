import java.util.HashSet;
import java.util.TreeSet;
import java.util.Set;

public class Task1 {
    public static void main(String[] args) {

        Set<String> hashSet = new HashSet<>();
        hashSet.add("orange");
        hashSet.add("apple");
        hashSet.add("banana");
        hashSet.add("pear");
        for (String s : hashSet) {
            System.out.println(s);
        }
        System.out.println();

        // Преобразование HashSet в TreeSet
        Set<String> treeSet = new TreeSet<>(hashSet);

        for (String s : treeSet) {
            System.out.println(s);
        }
    }
}
