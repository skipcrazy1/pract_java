package pract19.Task2.exceptions;

public class StudentNotFoundException extends RuntimeException{
    public StudentNotFoundException(String message){
        super(message);
    }
}
