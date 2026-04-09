package pract20.Task123;

public class Task3 {
    public static void main(String[] args){
        ConstrainedTriple<String, Animal> constrainedTriple =
                new ConstrainedTriple<>("Test", new Animal("Dog"));

        System.out.println("First: " + constrainedTriple.getFirst());
        System.out.println("Second: " + constrainedTriple.getSecond());

        // Используем Comparable
        System.out.println("Apple: " + constrainedTriple.isFirstGreaterThan("Apple"));
        System.out.println("Zebra: " + constrainedTriple.isFirstGreaterThan("Zebra"));
    }
}
