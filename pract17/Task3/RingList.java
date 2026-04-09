package pract17.Task3;

class RingList {
    Person head;

    boolean isEmpty() {
        return head == null;
    }

    void add(Person n) {
        if (head == null) {
            head = n;
            n.next = head;  // замыкаем на себя
        } else {
            Person last = head;
            while (last.next != head) {
                last = last.next;
            }
            last.next = n;
            n.next = head;
            head = n;  // добавляем в начало
        }
    }

    void remove(String name) {
        if (head == null) return;

        // Если список из одного элемента
        if (head.next == head && head.name.equals(name)) {
            head = null;
            return;
        }

        Person cur = head;
        Person prev = null;

        // Ищем элемент
        do {
            if (cur.name.equals(name)) break;
            prev = cur;
            cur = cur.next;
        } while (cur != head);

        if (cur == head && !cur.name.equals(name)) return; // не найден

        // Удаляем
        if (cur == head) {
            // Находим последний элемент
            Person last = head;
            while (last.next != head) {
                last = last.next;
            }
            head = head.next;
            last.next = head;
        } else {
            prev.next = cur.next;
        }
    }

    void show() {
        if (head == null) {
            System.out.println("Пусто");
            return;
        }

        Person cur = head;
        do {
            cur.print();
            cur = cur.next;
        } while (cur != head);
    }

    void clear() {
        head = null;
    }
}
