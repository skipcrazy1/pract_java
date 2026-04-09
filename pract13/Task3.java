package pract13;

import java.util.StringTokenizer;

public class Task3 {
    private String country;
    private String region;
    private String city;
    private String street;
    private String house;
    private String building;
    private String apartment;

    // Вариант a: split с запятой
    public void parseSplit(String Task3) {
        String[] parts = Task3.split(",");
        if (parts.length >= 7) {
            country = parts[0].trim();
            region = parts[1].trim();
            city = parts[2].trim();
            street = parts[3].trim();
            house = parts[4].trim();
            building = parts[5].trim();
            apartment = parts[6].trim();
        }
    }

    // Вариант b: StringTokenizer с несколькими разделителями
    public void parseTokenizer(String Task3) {
        StringTokenizer tokenizer = new StringTokenizer(Task3, ",.;-");
        String[] fields = new String[7];
        int i = 0;
        while (tokenizer.hasMoreTokens() && i < 7) {
            fields[i++] = tokenizer.nextToken().trim();
        }
        if (i >= 7) {
            country = fields[0];
            region = fields[1];
            city = fields[2];
            street = fields[3];
            house = fields[4];
            building = fields[5];
            apartment = fields[6];
        }
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s, %s, %s, %s, %s",
                country, region, city, street, house, building, apartment);
    }

    public static void main(String[] args) {
        Task3 addr1 = new Task3();
        addr1.parseSplit("Россия, Московская область, Москва, Ленина, 10, 2, 15");
        System.out.println("Split: " + addr1);

        Task3 addr2 = new Task3();
        addr2.parseTokenizer("США; Калифорния; Лос-Анджелес; Сансет; 123; 1; 5");
        System.out.println("Tokenizer: " + addr2);

        Task3 addr3 = new Task3();
        addr3.parseSplit("Германия, Бавария, Мюнхен, Мариенплац, 5, , 3");
        System.out.println("Split (пустое поле): " + addr3);

        Task3 addr4 = new Task3();
        addr4.parseTokenizer("Франция. Иль-де-Франс. Париж. Елисейские поля. 20. 3. 7");
        System.out.println("Tokenizer (точки): " + addr4);
    }
}