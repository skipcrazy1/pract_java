package pract20.Task123;

public class Task12 {
    public static void main(String[] args){
        Triple<String, Integer, Double> triple1 = new Triple<>("Hello", 123, 45.67);
        System.out.println(triple1);
        triple1.printClassNames();
    }
}
