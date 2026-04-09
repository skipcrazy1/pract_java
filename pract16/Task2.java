package pract16;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Task2 extends JFrame {
    private JTextArea textArea;

    public Task2() {
        setTitle("Редактор текста");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Текстовая область
        textArea = new JTextArea();
        textArea.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        textArea.setText("Пример текста для редактирования.");
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        // Меню
        JMenuBar menuBar = new JMenuBar();

        // Меню "Цвет"
        JMenu colorMenu = new JMenu("Цвет");
        JMenuItem blueItem = new JMenuItem("Синий");
        JMenuItem redItem = new JMenuItem("Красный");
        JMenuItem blackItem = new JMenuItem("Черный");

        blueItem.addActionListener(e -> textArea.setForeground(Color.BLUE));
        redItem.addActionListener(e -> textArea.setForeground(Color.RED));
        blackItem.addActionListener(e -> textArea.setForeground(Color.BLACK));

        colorMenu.add(blueItem);
        colorMenu.add(redItem);
        colorMenu.add(blackItem);

        // Меню "Шрифт"
        JMenu fontMenu = new JMenu("Шрифт");
        JMenuItem timesItem = new JMenuItem("Times New Roman");
        JMenuItem sansItem = new JMenuItem("MS Sans Serif");
        JMenuItem courierItem = new JMenuItem("Courier New");

        timesItem.addActionListener(e -> textArea.setFont(new Font("Times New Roman", Font.PLAIN, 14)));
        sansItem.addActionListener(e -> textArea.setFont(new Font("MS Sans Serif", Font.PLAIN, 14)));
        courierItem.addActionListener(e -> textArea.setFont(new Font("Courier New", Font.PLAIN, 14)));

        fontMenu.add(timesItem);
        fontMenu.add(sansItem);
        fontMenu.add(courierItem);

        menuBar.add(colorMenu);
        menuBar.add(fontMenu);

        setJMenuBar(menuBar);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Task2().setVisible(true);
        });
    }
}
