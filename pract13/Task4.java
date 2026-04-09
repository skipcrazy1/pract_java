package pract13;

public class Task4 {
    private String code;
    private String name;
    private String color;
    private String size;

    public Task4(String code, String name, String color, String size) {
        this.code = code;
        this.name = name;
        this.color = color;
        this.size = size;
    }

    @Override
    public String toString() {
        return String.format("Код: %s\nНаименование: %s\nЦвет: %s\nРазмер: %s\n",
                code, name, color, size);
    }

    public static void main(String[] args) {
        String[] Task4s = new String[] {
                "S001,Black Polo Task4,Black,XL",
                "S002,Black Polo Task4,Black,L",
                "S003,Blue Polo Task4,Blue,XL",
                "S004,Blue Polo Task4,Blue,M",
                "S005,Tan Polo Task4,Tan,XL",
                "S006,Black T-Task4,Black,XL",
                "S007,White T-Task4,White,XL",
                "S008,White T-Task4,White,L",
                "S009,Green T-Task4,Green,S",
                "S010,Orange T-Task4,Orange,S",
                "S011,Maroon Polo Task4,Maroon,S"
        };

        Task4[] Task4Array = new Task4[Task4s.length];
        for (int i = 0; i < Task4s.length; i++) {
            String[] parts = Task4s[i].split(",");
            Task4Array[i] = new Task4(parts[0], parts[1], parts[2], parts[3]);
        }

        for (Task4 Task4 : Task4Array) {
            System.out.println(Task4);
        }
    }
}
