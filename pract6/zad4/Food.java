package pract6.zad4;

public class Food implements Priceable {
    private double price;

    public Food(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
