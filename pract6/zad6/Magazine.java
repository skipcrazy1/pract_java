package pract6.zad6;

public class Magazine implements Printable {
    private String title;

    public Magazine(String title) {
        this.title = title;
    }

    public void print() {
        System.out.println("Журнал: " + title);
    }
}
