package pract21;

import java.io.File;

public class Task4 {
    public static void printFirst5DirItems(String path) {
        File dir = new File(path); //создание объекта File
        if (dir.exists() && dir.isDirectory()) {
            File[] files = dir.listFiles(); //список файлов каталога
            if (files != null) {
                for (int i = 0; i < Math.min(5, files.length); i++) {
                    System.out.println(files[i].getName());
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Первые 5 элементов каталога:");
        printFirst5DirItems("."); //текущий каталог где запущена программа
    }
}