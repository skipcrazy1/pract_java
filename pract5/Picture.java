package pract5;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Picture {

    public static void main(String[] args) {
        // Проверяем, передан ли путь к картинке
        if (args.length == 0) {
            System.out.println("Использование: java Picture /Users/muradgaliev/Desktop/photo/photo.jpeg");
            System.exit(1);
        }

        String imagePath = args[0];

        // Запускаем GUI в потоке обработки событий
        SwingUtilities.invokeLater(() -> {
            try {
                createAndShowGUI(imagePath);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private static void createAndShowGUI(String imagePath) throws IOException {
        // Создаем главное окно
        JFrame frame = new JFrame("Просмотр картинки");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Загружаем картинку
        BufferedImage image = ImageIO.read(new File(imagePath));

        // компонент для отображения картинки
        JLabel imageLabel = new JLabel(new ImageIcon(image));

        // компонент в окно
        frame.getContentPane().add(imageLabel, BorderLayout.CENTER);

        // размер окна по размеру картинки
        frame.pack();

        // Центр окно на экране
        frame.setLocationRelativeTo(null);

        // Делаем окно видимым
        frame.setVisible(true);
    }
}
