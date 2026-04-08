package pract6.zad6;

public class Main {
    public static void main(String[] args) {

        Printable[] arr = {
                new Book("Война и мир"),
                new Book("Гарри Поттер"),
                new Magazine("Forbes"),
                new Magazine("National Geographic"),
                new Shop("Книжный дом"),
                new Shop("Мир прессы")
        };

        for (Printable p : arr) {
            p.print();
        }
    }
}
