package pract19.Task2;

public class LabClassDriver {
    private final LabClass model;
    private final LabClassUI view;

    public LabClassDriver(LabClass model, LabClassUI view){
        this.model = model;
        this.view = view;
    }

    public Student getStudent(int index){
        return model.getStudent(index);
    }

    public Student findStudent(String fullName) {
        return model.findStudent(fullName);
    }

    public void addStudent(Student student){
        model.addStudent(student);
    }

    public void removeStudent(int index){
        model.removeStudent(index);
    }

    public void removeStudent(String fullName) {
        model.removeStudent(fullName);
    }

    public void clearStudents(){
        model.clearStudents();
    }

    public void sortStudentsByAverageGrade(){
        model.sortStudentsByAverageGrade();
    }

    public void displayStudent(Student student){
        view.displayStudent(student.getName(), String.valueOf(student.getAverageGrade()));
    }

    public void displayStudents(){
        view.displayStudents(model.getStudents());
    }
}
