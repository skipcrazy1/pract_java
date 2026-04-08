package pract6.zad6;

public class Book implements Printable {
    private String title;

    public Book(String title) {
        this.title = title;
    }

    public void print() {
        System.out.println("Книга: " + title);
    }
}
