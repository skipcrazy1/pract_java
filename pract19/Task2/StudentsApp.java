package pract19.Task2;

import pract19.Task2.exceptions.EmptyStringException;

import javax.swing.*;
import java.awt.*;

public class StudentsApp {
    public static void main(String[] args) {
        var font = new Font("MS Sans Serif", Font.PLAIN, 18);

        // главное окно
        var frame = new JFrame("Students description");
        var pane = frame.getContentPane();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(1200, 600);
        frame.setResizable(false);
        frame.setLayout(null);



        var model = new LabClass();
        var view = new LabClassUI(pane, font);
        var controller = new LabClassDriver(model, view);




        var studentActionPanel = new JPanel(null);
        studentActionPanel.setSize(400, 600);
        studentActionPanel.setLocation(400, 0);
        pane.add(studentActionPanel);

        var fullNameLabel = new JLabel("Введите ФИО студента");
        fullNameLabel.setSize(400, 50);
        fullNameLabel.setLocation(0, 0);
        fullNameLabel.setFont(font);
        fullNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        studentActionPanel.add(fullNameLabel);

        var fullNameTextArea = new JTextArea();
        fullNameTextArea.setSize(400, 20);
        fullNameTextArea.setLocation(0, 50);
        fullNameTextArea.setLineWrap(false);
        fullNameTextArea.setWrapStyleWord(false);
        studentActionPanel.add(fullNameTextArea);

        var studentIndexLabel = new JLabel("<html>Введите порядковый номер студента для поиска<br/>Или же ср. балл для добавления студента</html>");
        studentIndexLabel.setSize(400, 70);
        studentIndexLabel.setLocation(0, 80);
        studentIndexLabel.setFont(font);
        studentIndexLabel.setHorizontalAlignment(SwingConstants.CENTER);
        studentActionPanel.add(studentIndexLabel);

        var studentIndexTextArea = new JTextArea();
        studentIndexTextArea.setSize(400, 20);
        studentIndexTextArea.setLocation(0, 160);
        studentIndexTextArea.setLineWrap(false);
        studentIndexTextArea.setWrapStyleWord(false);
        studentActionPanel.add(studentIndexTextArea);

        var studentByFullNameButton = new JButton("Студент по ФИО");
        studentByFullNameButton.setSize(400, 50);
        studentByFullNameButton.setLocation(0, 200);
        studentActionPanel.add(studentByFullNameButton);

        var studentByIndexButton = new JButton("Студент по номеру");
        studentByIndexButton.setSize(400, 50);
        studentByIndexButton.setLocation(0, 250);
        studentActionPanel.add(studentByIndexButton);

        var addStudentButton = new JButton("Добавить студента");
        addStudentButton.setSize(400, 50);
        addStudentButton.setLocation(0, 300);
        studentActionPanel.add(addStudentButton);

        var removeStudentByIndexButton = new JButton("Удалить студента по номеру");
        removeStudentByIndexButton.setSize(400, 50);
        removeStudentByIndexButton.setLocation(0, 350);
        studentActionPanel.add(removeStudentByIndexButton);

        var removeStudentByFullNameButton = new JButton("Удалить студента по ФИО");
        removeStudentByFullNameButton.setSize(400, 50);
        removeStudentByFullNameButton.setLocation(0, 400);
        studentActionPanel.add(removeStudentByFullNameButton);

        var clearStudentsButton = new JButton("Очистить студентов");
        clearStudentsButton.setSize(400, 50);
        clearStudentsButton.setLocation(0, 450);
        studentActionPanel.add(clearStudentsButton);

        var sortStudentsButton = new JButton("Сортировать студентов");
        sortStudentsButton.setSize(400, 50);
        sortStudentsButton.setLocation(0, 500);
        studentActionPanel.add(sortStudentsButton);




        // Обработка кнокоп
        studentByFullNameButton.addActionListener(e -> {
            var text = fullNameTextArea.getText().trim();
            if (text.isEmpty())
                throw new EmptyStringException("Пустая строка!");

            var student = controller.findStudent(text);
            controller.displayStudent(student);
            fullNameTextArea.setText("");
            studentIndexTextArea.setText("");
        });

        studentByIndexButton.addActionListener(e -> {
            var text = studentIndexTextArea.getText().trim();
            if (text.isEmpty())
                throw new EmptyStringException("Пустая строка!");

            var student = controller.getStudent(Integer.parseInt(text));
            controller.displayStudent(student);
            fullNameTextArea.setText("");
            studentIndexTextArea.setText("");
        });

        addStudentButton.addActionListener(e -> {
            var text1 = fullNameTextArea.getText().trim();
            var text2 = studentIndexTextArea.getText().trim();
            if (text1.isEmpty() || text2.isEmpty())
                throw new EmptyStringException("Пустая строка!");

            controller.addStudent(new Student(text1, Double.parseDouble(text2)));
            controller.displayStudents();
            fullNameTextArea.setText("");
            studentIndexTextArea.setText("");
        });

        removeStudentByIndexButton.addActionListener(e -> {
            var text = studentIndexTextArea.getText().trim();
            if (text.isEmpty())
                throw new EmptyStringException("Пустая строка!");

            controller.removeStudent(Integer.parseInt(text));
            controller.displayStudents();
            fullNameTextArea.setText("");
            studentIndexTextArea.setText("");
        });

        removeStudentByFullNameButton.addActionListener(e -> {
            var text = fullNameTextArea.getText().trim();
            if (text.isEmpty())
                throw new EmptyStringException("Пустая строка!");

            controller.removeStudent(text);
            controller.displayStudents();
            fullNameTextArea.setText("");
            studentIndexTextArea.setText("");
        });

        clearStudentsButton.addActionListener(e -> {
            controller.clearStudents();
            controller.displayStudents();
            fullNameTextArea.setText("");
            studentIndexTextArea.setText("");
        });

        sortStudentsButton.addActionListener(e -> {
            controller.sortStudentsByAverageGrade();
            controller.displayStudents();
            fullNameTextArea.setText("");
            studentIndexTextArea.setText("");
        });

        frame.setVisible(true);
    }
}
