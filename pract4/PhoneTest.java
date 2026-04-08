package pract4;

public class PhoneTest {
    public static void main(String[] args) {
        //экземпляры класса
        Phone phone1 = new Phone("+79123456789", "Ipone", 17.2);
        Phone phone2 = new Phone("+79912345678", "Samung");
        Phone phone3 = new Phone();

        phone3.setNumber("+79981234567");
        phone3.setModel("Xiam");
        phone3.setWeight(719.0);

        //вывод значений переменных каждого объекта
        System.out.println("Инфрмация о телефонах");
        phone1.showInfo();
        phone2.showInfo();
        phone3.showInfo();
        System.out.println();

        //методы для каждого из объектов
        System.out.println("Получение звонков");
        phone1.receiveCall("Сильвестр");
        System.out.println("номер телефона: " + phone1.getNumber());
        System.out.println();

        phone2.receiveCall("Альбаба");
        System.out.println("Номер телефона: " + phone2.getNumber());
        System.out.println();

        phone3.receiveCall("Джон");
        System.out.println("Номер телефона: " + phone3.getNumber());
        System.out.println();

        //вызов перегруженного метода
        System.out.println("перегруженный метод receiveCall");
        phone1.receiveCall("Сильвестр", "+79123456789");
        phone2.receiveCall("Альбаба", "+79912345678");
        System.out.println();

        //метод sendmessage
        System.out.println("отправка сообзений");
        phone1.sendMessage("+79111111111", "+79222222222", "+79333333333");
        phone2.sendMessage("+79212121212");
        phone3.sendMessage();
    }
}
