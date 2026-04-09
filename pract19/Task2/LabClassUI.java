package pract19.Task2;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class LabClassUI {
    private final JLabel studentGroup;
    private final JLabel studentInfo;
    private final StringBuilder sb;

    public LabClassUI(Container pane, Font font){
        studentGroup = createStudentList(pane, font);
        studentInfo = createStudentInfo(pane, font);

        sb = new StringBuilder();
    }

    public void displayStudent(String... studentInfos){
        sb.setLength(0);
        for (var studentInfo : studentInfos){
            sb.append(studentInfo);
            sb.append("<br/>");
        }
        sb.insert(0, "<html>");
        sb.insert(sb.length() - 1, "</html>");
        studentInfo.setText(sb.toString());
    }

    public void displayStudents(List<Student> students){
        sb.setLength(0);
        for (int i = 0; i < students.size(); i++) {
            if (i != 0)
                sb.append("<br/>");
            sb.append(students.get(i));
        }

        sb.insert(0, "<html>");
        sb.insert(sb.length() - 1, "/<html>");
        studentGroup.setText(sb.toString());
    }

    private JLabel createStudentList(Container pane, Font font){
        // сипсок студентов
        var listOfStudentsPanel = new JPanel();
        listOfStudentsPanel.setSize(400, 600);
        listOfStudentsPanel.setLocation(0, 0);
        pane.add(listOfStudentsPanel);

        var listOfStudentsHeaderLabel = new JLabel("Список студентов");
        listOfStudentsHeaderLabel.setSize(400, 50);
        listOfStudentsHeaderLabel.setLocation(0, 0);
        listOfStudentsHeaderLabel.setFont(font);
        listOfStudentsHeaderLabel.setHorizontalAlignment(SwingConstants.CENTER);
        listOfStudentsPanel.add(listOfStudentsHeaderLabel);

        var listOfStudentsLabel = new JLabel();
        listOfStudentsLabel.setSize(400, 550);
        listOfStudentsLabel.setLocation(0, 50);
        listOfStudentsLabel.setFont(font);
        listOfStudentsLabel.setHorizontalAlignment(SwingConstants.LEFT);
        listOfStudentsLabel.setVerticalAlignment(SwingConstants.TOP);
        listOfStudentsPanel.add(listOfStudentsLabel);
        return listOfStudentsLabel;
    }

    private JLabel createStudentInfo(Container pane, Font font){
        // отчет по студенту
        var studentInfoPanel = new JPanel(null);
        studentInfoPanel.setSize(400, 600);
        studentInfoPanel.setLocation(800, 0);
        pane.add(studentInfoPanel);

        var studentDescriptionHeaderLabel = new JLabel("Отчет по студенту");
        studentDescriptionHeaderLabel.setSize(400, 50);
        studentDescriptionHeaderLabel.setLocation(0, 0);
        studentDescriptionHeaderLabel.setFont(font);
        studentDescriptionHeaderLabel.setHorizontalAlignment(SwingConstants.CENTER);
        studentInfoPanel.add(studentDescriptionHeaderLabel);

        var studentDescription = new JLabel();
        studentDescription.setSize(400, 550);
        studentDescription.setLocation(0, 50);
        studentDescription.setFont(font);
        studentDescription.setHorizontalAlignment(SwingConstants.LEFT);
        studentDescription.setVerticalAlignment(SwingConstants.TOP);
        studentInfoPanel.add(studentDescription);
        return studentDescription;
    }
}
