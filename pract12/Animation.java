package pract12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Animation extends JFrame implements ActionListener {
    private Timer timer;
    private int currentFrame = 0;
    private ImageIcon[] photos;
    private JLabel photoLabel;

    public Animation() {
        super("Анимация из фотографий");
        setSize(600, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Создаем метку для фотографий
        photoLabel = new JLabel();
        photoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(photoLabel, BorderLayout.CENTER);

        // Загружаем фотографии
        loadPhotos();

        // Запускаем анимацию (смена каждую секунду)
        timer = new Timer(100, this);
        timer.start();

        // Показываем первый кадр
        showCurrentPhoto();

        setVisible(true);
    }

    private void loadPhotos() {
        // Массив с именами файлов
        String[] photoNames = {
                "photo1.png",
                "photo2.png",
                "photo3.png",
                "photo4.png",
                "photo5.png",
                "photo6.png",
                "photo7.png",
                "photo8.png",
                "photo9.png",
                "photo10.png",
                "photo11.png",
                "photo12.png",
                "photo13.png"
        };

        photos = new ImageIcon[photoNames.length];

        for (int i = 0; i < photoNames.length; i++) {
            File file = new File(photoNames[i]);
            if (file.exists()) {
                try {
                    photos[i] = new ImageIcon(photoNames[i]);
                    System.out.println("Загружено: " + photoNames[i]);
                } catch (Exception e) {
                    System.out.println("Ошибка загрузки: " + photoNames[i]);
                    photos[i] = createTestIcon(i);
                }
            } else {
                System.out.println("Файл не найден: " + photoNames[i]);
                photos[i] = createTestIcon(i);
            }
        }

        // Проверяем сколько фото загрузилось
        int loadedCount = 0;
        for (ImageIcon photo : photos) {
            if (photo != null) loadedCount++;
        }
        System.out.println("Всего загружено фото: " + loadedCount + " из " + photos.length);
    }

    private ImageIcon createTestIcon(int frameNum) {
        int width = 400;
        int height = 300;

        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = img.createGraphics();

        // Фон
        Color bgColor = Color.getHSBColor(frameNum / 13.0f, 0.7f, 0.9f);
        g2d.setColor(bgColor);
        g2d.fillRect(0, 0, width, height);

        // Текст
        g2d.setColor(Color.WHITE);
        g2d.setFont(new Font("Arial", Font.BOLD, 36));
        String text = "ФОТО " + (frameNum + 1);
        FontMetrics fm = g2d.getFontMetrics();
        int textWidth = fm.stringWidth(text);
        g2d.drawString(text, (width - textWidth) / 2, height / 2);

        // Инструкция
        g2d.setFont(new Font("Arial", Font.PLAIN, 14));
        g2d.drawString("photo" + (frameNum + 1) + ".png не найден", 50, height - 50);

        g2d.dispose();
        return new ImageIcon(img);
    }

    private void showCurrentPhoto() {
        if (photos[currentFrame] != null) {
            // Масштабируем изображение
            ImageIcon icon = photos[currentFrame];
            Image scaledImage = icon.getImage().getScaledInstance(
                    550,  // ширина
                    400,  // высота
                    Image.SCALE_SMOOTH
            );
            photoLabel.setIcon(new ImageIcon(scaledImage));

            // Информация в заголовке окна
            setTitle("Анимация - Кадр " + (currentFrame + 1) + "/" + photos.length);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Следующий кадр
        currentFrame = (currentFrame + 1) % photos.length;
        showCurrentPhoto();
    }

    public static void main(String[] args) {
        // Проверяем текущую папку
        File currentDir = new File(".");
        System.out.println("Текущая папка: " + currentDir.getAbsolutePath());

        // Показываем все файлы
        System.out.println("Содержимое папки:");
        String[] files = currentDir.list();
        if (files != null) {
            for (String file : files) {
                if (file.toLowerCase().endsWith(".png") || file.toLowerCase().endsWith(".jpg")) {
                    System.out.println("  - " + file);
                }
            }
        }

        new Animation();
    }
}