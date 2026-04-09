package pract9;

public class Student implements Comparable<Student> {// говорит Java, что объекты Student можно сравнивать между собой, чтобы сортировать.
    //говорит, что Student реализует интерфейс Comparable<Student>, т.е. объекты Student умеют сравниваться между собой
    //Это нужно, чтобы массив Student[] можно было сортировать стандартными способами (сортировку ты написал сама).
    //<Student> — дженерик: метод compareTo будет принимать именно Student как аргумент.
    private int iDNumber;
    private String name;

    public Student(int iDNumber, String name) {//конструктор, вызывается new Student
        this.iDNumber = iDNumber; //присваиваем полям знаение
        this.name = name;
    }

    public int getiDNumber() {
        return iDNumber;
    } //геттер возвращает значение IDNumber

    @Override
    //Аннотация. Говорит компилятору: метод ниже должен переопределять метод суперкласса/интерфейса.
    public int compareTo(Student other) { //Это метод из интерфейса Comparable<Student>.
        // public int compareTo(Student other) — определяет правило сравнения this (текущий объект) и other (переданный объект).
        //Когда сортировка вызывает a.compareTo(b):
        //this = a
        //other = b
        return this.iDNumber - other.iDNumber;//Если результат < 0 → this считается меньше other.
    }

    @Override
    public String toString() {//toString() — метод, который возвращает строковое представление объекта.
        return iDNumber + " - " + name; //Java вызывает someStudent.toString() автоматически.
    }
}

