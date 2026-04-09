package pract15;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Task1 extends JFrame {
    JTextField num1Field = new JTextField(10);
    JTextField num2Field = new JTextField(10);
    JComboBox<String> operationBox = new JComboBox<>(new String[]{"+", "-", "*", "/"});
    JButton calculateButton = new JButton("Calculate");
    JLabel resultLabel = new JLabel("Result: ");

    Task1() {
        super("Calculator");
        setLayout(new FlowLayout());
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new JLabel("Number 1:"));
        add(num1Field);
        add(new JLabel("Number 2:"));
        add(num2Field);
        add(new JLabel("Operation:"));
        add(operationBox);
        add(calculateButton);
        add(resultLabel);

        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double x1 = Double.parseDouble(num1Field.getText().trim());
                    double x2 = Double.parseDouble(num2Field.getText().trim());
                    String op = (String) operationBox.getSelectedItem();
                    double result = 0;
                    switch (op) {
                        case "+": result = x1 + x2; break;
                        case "-": result = x1 - x2; break;
                        case "*": result = x1 * x2; break;
                        case "/": result = x1 / x2; break;
                    }
                    resultLabel.setText("Result: " + result);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error in input!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new Task1();
    }
}