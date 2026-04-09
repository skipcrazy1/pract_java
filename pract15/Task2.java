package pract15;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Task2 extends JFrame {
    JComboBox<String> countryBox = new JComboBox<>(new String[]{
            "Australia", "China", "England", "Russia"
    });
    JTextArea infoArea = new JTextArea(5, 20);

    Task2() {
        super("Country Info");
        setLayout(new FlowLayout());
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new JLabel("Select country:"));
        add(countryBox);
        add(new JScrollPane(infoArea));

        countryBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String country = (String) countryBox.getSelectedItem();
                String info = "";
                switch (country) {
                    case "Australia": info = "Столица: Canberra\nНаселение: ~26 миллиона"; break;
                    case "China": info = "Столица: Beijing\nНаселение: ~1.4 миллиарда"; break;
                    case "England": info = "Столица: London\nНаселение: ~56 миллиона"; break;
                    case "Russia": info = "Столица: Moscow\nНаселение: ~144 миллиона"; break;
                }
                infoArea.setText(info);
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new Task2();
    }
}