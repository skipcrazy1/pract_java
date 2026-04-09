package pract20.Task123;

import java.io.Serializable;

// Класс Animal для задания 3
class Animal implements Serializable {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Animal: " + name;
    }
}
