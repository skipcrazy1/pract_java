package pract6.zad4;

public class Main {
    public static void main(String[] args) {
        Priceable phone = new Phone(799.99);
        Priceable apple = new Food(1.49);

        System.out.println(phone.getPrice());
        System.out.println(apple.getPrice());
    }
}
