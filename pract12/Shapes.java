package pract12;
import javax.swing.*;
import java.awt.*;
import java.util.Random;

// Простой абстрактный класс Shape
abstract class Shape {
    Color color;
    int x, y;

    Shape(Color color, int x, int y) {
        this.color = color;
        this.x = x;
        this.y = y;
    }

    abstract void draw(Graphics g);
}

// Круг
class Circle extends Shape {
    int radius;

    Circle(Color color, int x, int y, int radius) {
        super(color, x, y);
        this.radius = radius;
    }

    void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, radius * 2, radius * 2);
    }
}

// Прямоугольник
class Rect extends Shape {
    int width, height;

    Rect(Color color, int x, int y, int width, int height) {
        super(color, x, y);
        this.width = width;
        this.height = height;
    }

    void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }
}

// Треугольник
class Triangle extends Shape {
    int size;

    Triangle(Color color, int x, int y, int size) {
        super(color, x, y);
        this.size = size;
    }

    void draw(Graphics g) {
        g.setColor(color);

        // Координаты вершин треугольника
        int[] xPoints = {x, x + size, x + size / 2};
        int[] yPoints = {y + size, y + size, y};

        g.fillPolygon(xPoints, yPoints, 3);
    }
}

// Главное окно
public class Shapes extends JFrame {

    public Shapes() {
        super("20 Случайных фигур");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Панель для рисования
        JPanel panel = new JPanel() {
            Shape[] shapes = new Shape[20];
            Random rand = new Random();

            {
                // Создаем 20 случайных фигур
                for (int i = 0; i < 20; i++) {
                    Color color = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
                    int x = rand.nextInt(700);
                    int y = rand.nextInt(500);

                    // Случайно выбираем тип фигуры
                    int shapeType = rand.nextInt(3); // 0, 1 или 2

                    if (shapeType == 0) {
                        // Круг
                        int radius = 20 + rand.nextInt(50);
                        shapes[i] = new Circle(color, x, y, radius);
                    }
                    else if (shapeType == 1) {
                        // Прямоугольник
                        int width = 30 + rand.nextInt(100);
                        int height = 30 + rand.nextInt(100);
                        shapes[i] = new Rect(color, x, y, width, height);
                    }
                    else {
                        // Треугольник
                        int size = 40 + rand.nextInt(80);
                        shapes[i] = new Triangle(color, x, y, size);
                    }
                }
            }

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Рисуем все фигуры
                for (Shape shape : shapes) {
                    if (shape != null) {
                        shape.draw(g);
                    }
                }
                // Информация
                g.setColor(Color.BLACK);
                g.setFont(new Font("Arial", Font.BOLD, 16));
                g.drawString("20 случайных фигур (круги, прямоугольники, треугольники)", 10, 20);

                // Легенда внизу
                g.setColor(Color.RED);
                g.fillOval(10, 530, 20, 20);
                g.setColor(Color.BLACK);
                g.drawString(" - Круги", 35, 545);

                g.setColor(Color.BLUE);
                g.fillRect(150, 530, 20, 20);
                g.setColor(Color.BLACK);
                g.drawString(" - Прямоугольники", 175, 545);

                g.setColor(Color.GREEN);
                int[] triX = {290, 310, 300};
                int[] triY = {540, 540, 530};
                g.fillPolygon(triX, triY, 3);
                g.setColor(Color.BLACK);
                g.drawString(" - Треугольники", 315, 545);
            }
        };

        // Добавляем кнопку для перегенерации фигур
        JButton regenerateBtn = new JButton("Новые фигуры");
        regenerateBtn.addActionListener(e -> {
            // Перерисовываем панель
            panel.repaint();
        });

        // Размещаем компоненты
        setLayout(new BorderLayout());
        add(panel, BorderLayout.CENTER);
        add(regenerateBtn, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Shapes();
    }
}