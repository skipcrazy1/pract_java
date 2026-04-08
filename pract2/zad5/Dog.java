package pract2.zad5;

public class Dog {
    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
    public int getAge() {
        return this.age;
    }
    public String toString() {
        return "Name - " + this.name + "; Age - " + this.age;
    }
    public int humanAge() {
        return this.age * 7;
    }
}
