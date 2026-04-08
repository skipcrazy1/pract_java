package pract4;

public class SeasonsTest {
    public static void main(String[] args) {
        // 1) любимое время года
        Seasons favoriteSeason = Seasons.SUMMER;
        System.out.println("Мое любимое время года: " + favoriteSeason);
        System.out.println("Средняя температура: " + favoriteSeason.getAverageTemperature() + "°C");
        System.out.println("Описание: " + favoriteSeason.getDescription());
        System.out.println();

        // 2) метод, который принимает переменную enum типа
        printSeasonPreference(Seasons.SUMMER);
        printSeasonPreference(Seasons.WINTER);
        printSeasonPreference(Seasons.SPRING);
        printSeasonPreference(Seasons.AUTUMN);
        System.out.println();

        // 6) все времена года, средняя темп и описание
        System.out.println("Все времена года:");
        for (Seasons season : Seasons.values()) {
            System.out.println(season.getRussianName() +
                    " - Средняя температура: " + season.getAverageTemperature() + "°C" +
                    " - " + season.getDescription());
        }
    }

    // предпочтение по времени года
    public static void printSeasonPreference(Seasons season) {
        switch (season) {
            case WINTER:
                System.out.println("Я люблю зиму");
                break;
            case SPRING:
                System.out.println("Я люблю весну");
                break;
            case SUMMER:
                System.out.println("Я люблю лето");
                break;
            case AUTUMN:
                System.out.println("Я люблю осень");
                break;
        }
    }
}