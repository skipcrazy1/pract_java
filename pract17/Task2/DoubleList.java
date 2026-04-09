package pract17.Task2;

class DoubleList {
    Person head, tail;

    boolean isEmpty() {
        return head == null;
    }

    void add(Person n) {
        if (head == null) {
            head = tail = n;
        } else {
            tail.next = n;
            n.prev = tail;
            tail = n;
        }
    }

    void remove(String name) {
        Person cur = head;
        while (cur != null && !cur.name.equals(name)) {
            cur = cur.next;
        }
        if (cur == null) return;

        if (cur == head && cur == tail) {
            head = tail = null;
        } else if (cur == head) {
            head = head.next;
            head.prev = null;
        } else if (cur == tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            cur.prev.next = cur.next;
            cur.next.prev = cur.prev;
        }
    }

    void showForward() {
        Person cur = head;
        while (cur != null) {
            cur.print();
            cur = cur.next;
        }
    }

    void showBackward() {
        Person cur = tail;
        while (cur != null) {
            cur.print();
            cur = cur.prev;
        }
    }

    void clear() {
        head = tail = null;
    }
}
