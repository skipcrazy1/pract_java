package pract17.Task1;

// 2. Контейнерный класс Список
class List {
    Person head;

    // a. Создание пустого списка (конструктор)
    List() {
        head = null;
    }

    // b. Добавление элемента
    void add(Person node) {
        node.next = head;
        head = node;
    }

    // c. Удаление элемента по имени
    void remove(String name) {
        if (head == null) return;

        if (head.name.equals(name)) {
            head = head.next;
            return;
        }

        Person current = head;
        while (current.next != null && !current.next.name.equals(name)) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    // d. Вывод всех элементов
    void printAll() {
        Person current = head;
        while (current != null) {
            current.printToConsole();
            current = current.next;
        }
    }

    // e. Очистка списка
    void clear() {
        head = null;
    }

    // f. Проверка на пустоту
    boolean isEmpty() {
        return head == null;
    }
}
