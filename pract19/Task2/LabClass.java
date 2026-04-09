package pract19.Task2;

import pract19.Task2.exceptions.StudentNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class LabClass {
    private final List<Student> students;

    public LabClass(){
        students = new ArrayList<Student>();
    }

    public List<Student> getStudents(){
        return new ArrayList<>(students);
    }

    public Student getStudent(int index){
        if (index >= students.size())
            return null;
        return students.get(index);
    }

    public Student findStudent(String fullName) {
        var possibleStudent = students.stream().filter(student -> student.getName().equals(fullName)).findFirst();
        if (possibleStudent.isEmpty())
            throw new StudentNotFoundException("Невозможно найти студента по ФИО: " + fullName);
        return possibleStudent.get();
    }

    public void addStudent(Student student){
        if (!students.contains(student))
            students.add(student);
    }

    public void removeStudent(Student student){
        students.remove(student);
    }

    public void removeStudent(int index){
        students.remove(index);
    }

    public void removeStudent(String fullName) {
        var student = findStudent(fullName);
        if (student != null)
            students.remove(findStudent(fullName));
    }

    public void clearStudents(){
        students.clear();
    }

    public void sortStudentsByAverageGrade(){
        students.sort(Student::compareTo);
    }
}
