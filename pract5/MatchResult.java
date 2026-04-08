package pract5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MatchResult extends JFrame {
    private int milanScore = 0;
    private int madridScore = 0;
    private String lastScorer = "N/A";
    private String winner = "Ничья!";

    private JButton milanButton = new JButton("AC Milan");
    private JButton madridButton = new JButton("Real Madrid");
    private JLabel resultLabel = new JLabel("Результат: 0 X 0", JLabel.CENTER);
    private JLabel lastScorerLabel = new JLabel("Последний забивший: N/A", JLabel.CENTER);
    private JLabel winnerLabel = new JLabel("Победитель: НИЧЬЯ", JLabel.CENTER);

    public MatchResult() {
        setTitle("Футбольный матч: AC Milan vs Real Madrid");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 250);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Настройка компонентов
        setupComponents();

        // Создаем и добавляем панели
        add(createTitlePanel(), BorderLayout.NORTH);
        add(createButtonPanel(), BorderLayout.CENTER);
        add(createInfoPanel(), BorderLayout.SOUTH);

        setVisible(true);
    }

    private void setupComponents() {
        // Настройка шрифтов
        Font buttonFont = new Font("Arial", Font.BOLD, 16);
        Font resultFont = new Font("Arial", Font.BOLD, 18);

        milanButton.setFont(buttonFont);
        madridButton.setFont(buttonFont);
        resultLabel.setFont(resultFont);

        // Настройка цветов кнопок
        milanButton.setBackground(new Color(200, 16, 46)); // Красный Милан
        milanButton.setForeground(Color.WHITE);
        milanButton.setOpaque(true);
        milanButton.setBorderPainted(false);

        madridButton.setBackground(new Color(255, 205, 0)); // Золотой Мадрид
        madridButton.setForeground(Color.BLACK);
        madridButton.setOpaque(true);
        madridButton.setBorderPainted(false);

        // Обработчики событий
        milanButton.addActionListener(e -> updateScore("AC Milan"));
        madridButton.addActionListener(e -> updateScore("Real Madrid"));
    }

    private JPanel createTitlePanel() {
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(new Color(240, 240, 240));
        JLabel title = new JLabel("AC Milan vs Real Madrid");
        title.setFont(new Font("Arial", Font.BOLD, 18));
        titlePanel.add(title);
        return titlePanel;
    }

    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 20, 0));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        buttonPanel.setBackground(Color.WHITE);

        buttonPanel.add(milanButton);
        buttonPanel.add(madridButton);

        return buttonPanel;
    }

    private JPanel createInfoPanel() {
        JPanel infoPanel = new JPanel(new GridLayout(3, 1, 5, 5));
        infoPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 20));
        infoPanel.setBackground(Color.WHITE);

        infoPanel.add(resultLabel);
        infoPanel.add(lastScorerLabel);
        infoPanel.add(winnerLabel);

        return infoPanel;
    }

    private void updateScore(String team) {
        if (team.equals("AC Milan")) {
            milanScore++;
        } else {
            madridScore++;
        }
        lastScorer = team;
        updateDisplay();
    }

    private void updateDisplay() {
        // Обновление результата
        resultLabel.setText("Результат: " + milanScore + " X " + madridScore);
        lastScorerLabel.setText("Последний забивший: " + lastScorer);

        // Определяем победителя
        if (milanScore > madridScore) {
            winner = "AC Milan";
            winnerLabel.setForeground(new Color(200, 16, 46)); // Красный
        } else if (madridScore > milanScore) {
            winner = "Real Madrid";
            winnerLabel.setForeground(new Color(255, 205, 0)); // Золотой
        } else {
            winner = "Ничья!";
            winnerLabel.setForeground(Color.BLUE);
        }
        winnerLabel.setText("Победитель: " + winner);

        // Цвет последнего забившего
        if (lastScorer.equals("AC Milan")) {
            lastScorerLabel.setForeground(new Color(200, 16, 46));
        } else {
            lastScorerLabel.setForeground(new Color(255, 205, 0));
        }
    }

    public static void main(String[] args) {
        new MatchResult();
    }
}