package pract10;

public class Student {
    private String name;
    private String surname;
    private String speciality;
    private int course;
    private String group;
    private double gpa;

    public Student(String name, String surname, String speciality, int course, String group, double gpa) {
        this.name = name;
        this.surname = surname;
        this.speciality = speciality;
        this.course = course;
        this.group = group;
        this.gpa = gpa;
    }

    public String getName() { return name; }
    public String getSurname() { return surname; }
    public String getSpeciality() { return speciality; }
    public int getCourse() { return course; }
    public String getGroup() { return group; }
    public double getGpa() { return gpa; }

    @Override
    public String toString() {
        return surname + " " + name + " — " + gpa;
    }
}
