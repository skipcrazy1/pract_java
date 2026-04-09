package pract13;

public class Task2 {
    private String lastName;
    private String firstName;
    private String middleName;

    public Task2(String lastName, String firstName, String middleName) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
    }

    public String getFullName() {
        StringBuilder sb = new StringBuilder(lastName);
        if (firstName != null && !firstName.isEmpty()) {
            sb.append(" ").append(firstName.charAt(0)).append(".");
        }
        if (middleName != null && !middleName.isEmpty()) {
            sb.append(middleName.charAt(0)).append(".");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Task2 p1 = new Task2("Иванов", "Иван", "Иванович");
        Task2 p2 = new Task2("Петров", "Петр", null);
        Task2 p3 = new Task2("Сидоров", null, null);

        System.out.println(p1.getFullName());
        System.out.println(p2.getFullName());
        System.out.println(p3.getFullName());
    }
}