package pract6.zad3;

public class Animal implements Nameable {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {//ему необходимо использовать методы которые описаны в интерфейсе
        return name;
    }
}