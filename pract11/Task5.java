package pract11;

import java.util.*; // подключаем все классы из пакета java.util:
// ArrayList, LinkedList, List, и др.

public class Task5 {
    public static void main(String[] args) {

        List<Integer> arrayList = new ArrayList<>();   // 1) создаём ArrayList — внутри обычный массив
        //ArrayList
        //Это класс, который реализует интерфейс List.
        List<Integer> linkedList = new LinkedList<>(); // 2) создаём LinkedList — двусвязный список

        long start, end; // 3) переменные для измерения времени

        // === ДОБАВЛЕНИЕ 100000 ЭЛЕМЕНТОВ ===
        start = System.currentTimeMillis();            // 4) запоминаем время перед добавлением
        for(int i = 0; i < 100000; i++) arrayList.add(i); // 5) добавляем элементы в конец ArrayList
        end = System.currentTimeMillis();              // 6) замер после добавления
        System.out.println("ArrayList добавление: " + (end - start) + " ms"); // 7) выводим разницу

        start = System.currentTimeMillis();            // 😍 старт таймера для LinkedList
        for(int i = 0; i < 100000; i++) linkedList.add(i); // 9) добавляем элементы в конец LinkedList
        end = System.currentTimeMillis();              // 10) стоп таймера
        System.out.println("LinkedList добавление: " + (end - start) + " ms"); // 11)


        // === ВСТАВКА В НАЧАЛО ===
        start = System.currentTimeMillis();            // 12) старт таймера
        arrayList.add(0, 999);           // 13) вставка в начало ArrayList → сдвигает все 100000 элементов
        end = System.currentTimeMillis();              // 14)
        System.out.println("ArrayList вставка в начало: " + (end - start) + " ms"); // 15)

        start = System.currentTimeMillis();            // 16)
        linkedList.add(0, 999);        // 17) вставка в начало LinkedList → изменяются ссылки (быстро)
        end = System.currentTimeMillis();              // 18)
        System.out.println("LinkedList вставка в начало: " + (end - start) + " ms"); // 19)


        // === ПОИСК ЭЛЕМЕНТА ===
        start = System.currentTimeMillis();            // 20)
        arrayList.contains(90000);                     // 21) поиск в ArrayList (линейный проход массива)
        end = System.currentTimeMillis();              // 22)
        System.out.println("ArrayList поиск: " + (end - start) + " ms"); // 23)

        start = System.currentTimeMillis();            // 24)
        linkedList.contains(90000);                    // 25) поиск в LinkedList (линейный, но медленнее)
        end = System.currentTimeMillis();              // 26)
        System.out.println("LinkedList поиск: " + (end - start) + " ms"); // 27)
    }
}

//ArrayList — быстрый доступ по индексу, эффективная последовательная работа, медленная вставка в середину/начало.
//LinkedList — быстрые вставки/удаления в середине/начале (если у тебя ссылка на узел), но медленный произвольный доступ и худшая локальность памяти.
//ArrayList хранит элементы во внутреннем массиве Object[].
//LinkedList хранит элементы в узлах (Node) с ссылками prev и next
//ArrayList
//хранит данные в обычном массиве.
//Быстро: add, get
//Медленно: insert(0), remove(0)
//
//LinkedList
//хранит элементы в виде цепочки узлов.
//Быстро: вставка в начало и конец
//Медленно: поиск и обращение по индексу
