package pract24;

public class Test {
    public static void main(String[] args) {
        CompexAbstractFactory f = new ConcreteFactory();

        System.out.println("createComplex(): " + f.createComplex());
        System.out.println("createComplex(3,4): " + f.createComplex(3,4));
        System.out.println("createComplex(1,-2): " + f.createComplex(1,-2));
        System.out.println("createComplex(-5,0): " + f.createComplex(-5,0));

        System.out.println("CompexAbstractFactory (с опечаткой)");
        System.out.println("createComplex(): Complex");
        System.out.println("createComplex(int,int): Complex");
        System.out.println("ConcreteFactory реализует интерфейс");
        System.out.println("Паттерн: Абстрактная Фабрика");
    }
}
