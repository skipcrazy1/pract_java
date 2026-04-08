package pract4;

// Перечисление времен года
public enum Seasons {
    WINTER("Зима", -5.0) {
        @Override
        public String getDescription() {
            return "Холодное время года";
        }
    },
    SPRING("Весна", 10.0) {
        @Override
        public String getDescription() {
            return "Холодное время года";
        }
    },
    SUMMER("Лето", 22.0) {
        @Override
        public String getDescription() {
            return "Теплое время года";
        }
    },
    AUTUMN("Осень", 8.0) {
        @Override
        public String getDescription() {
            return "Холодное время года";
        }
    };

    private final String russianName;
    private final double averageTemperature;

    Seasons(String russianName, double averageTemperature) {
        this.russianName = russianName;
        this.averageTemperature = averageTemperature;
    }

    public String getRussianName() {
        return russianName;
    }

    public double getAverageTemperature() {
        return averageTemperature;
    }

    // Абстрактный метод
    public abstract String getDescription();

    @Override
    public String toString() {
        return russianName + " (средняя температура: " + averageTemperature + "°C)";
    }
}