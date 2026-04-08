package pract4;

public class Phone {
    String number;
    String model;
    double weight;

    //Конструктор с 3-мя переменными
    public Phone(String number, String model, double weight)
    {
        this.number = number;
        this.model = model;
        this.weight = weight;
    }
    public Phone(String number, String model){
        this.number = number;
        this.model = model;
        this.weight = 0.0;
    }
    public Phone(){
        this.number = "Не указан";
        this.model = "Не указан";
        this.weight = 0.0;
    }

    public void receiveCall(String callerName){
        System.out.println("Входящий от " + callerName);
    }
    // перегруженный метод с двумя переменными
    public void receiveCall(String callerName, String callerNumber){
        System.out.println("Входящий от " + callerName + " с номером " + callerNumber);
    }

    public String getNumber(){
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public String getModel(){
        return model;
    }
    public void setModel(String model){
        this.model = model;
    }
    public double getWeight(){
        return weight;
    }
    public void setWeight(double weight){
        this.weight = weight;
    }
    //метод с аргументами переменной длины
    public void sendMessage(String... phoneNumbers){
        System.out.println("сообщение будет отправленно на следующие номера");
        for (String phoneNumber: phoneNumbers){
            System.out.println(phoneNumber);
        }
    }

    public void showInfo(){
        System.out.println("Номер: "+ number + ", Модель: " + model + ", Вес: " + weight+ "г");
    }
}
