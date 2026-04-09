package pract13;

import java.util.*;

public class Task6 {
    public static String getLine(String... words) {
        if (words.length == 0) return "";
        List<String> wordList = new ArrayList<>(Arrays.asList(words));
        StringBuilder result = new StringBuilder(wordList.remove(0));

        boolean found;
        do {
            found = false;
            char lastChar = Character.toLowerCase(result.charAt(result.length() - 1));
            for (int i = 0; i < wordList.size(); i++) {
                String word = wordList.get(i);
                if (Character.toLowerCase(word.charAt(0)) == lastChar) {
                    result.append(" ").append(word);
                    wordList.remove(i);
                    found = true;
                    break;
                }
            }
        } while (found && !wordList.isEmpty());

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите слова через пробел: ");
        String input = scanner.nextLine();
        String[] words = input.split("\\s+");

        System.out.println("Результат: " + getLine(words));
        scanner.close();
    }
}
