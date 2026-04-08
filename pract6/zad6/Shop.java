package pract6.zad6;

public class Shop implements Printable {
    private String name;

    public Shop(String name) {
        this.name = name;
    }

    public void print() {
        System.out.println("Магазин: " + name);
    }
}
