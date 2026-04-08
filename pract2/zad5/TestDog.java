package pract2.zad5;

public class TestDog {
    public static void main(String[] args) {
        Dog dog = new Dog("Зверь", 2);
        System.out.println("Имя собаки: " + dog.getName());
        System.out.println("Возраст собаки: " + dog.getAge());
        System.out.println("Информация о собаке:\n" + dog.toString());
        System.out.println("Возраст в 'человеческих годах': " + dog.humanAge());
        dog.setName("Рекс");
        dog.setAge(5);
        System.out.println("Новое имя собаки: " + dog.getName());
        System.out.println("Новый возраст собаки: " + dog.getAge());
        System.out.println("Возраст в 'человеческих годах' после изменения: " + dog.humanAge());
    }
}
