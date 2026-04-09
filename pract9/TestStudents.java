package pract9;

public class TestStudents {
    public static void main(String[] args) {

        Student[] students = {
                new Student(5, "Alex"),//вызывается конструктор, создаётся объект в куче, переменная массива хранит ссылку на этот объект.
                new Student(1, "Maria"),
                new Student(3, "Ivan"),
                new Student(2, "Olga")
        };

        Sorting.insertionSort(students);

        for (Student s : students) { //Это for-each цикл (усовершенствованный цикл for):
            //Он пробегает по каждому элементу массива students.
            //В каждой итерации переменная s ссылается на текущий объект Student.
            //System.out.println(s) печатает s.toString() автоматически.
            System.out.println(s);
        }
    }
}
