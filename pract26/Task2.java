import java.util.Iterator;

interface List<T> extends Iterable<T> {
    void add(T item);
    T get(int index);
    int size();
}

//Реализация List с итератором
class MyList<T> implements List<T> {
    private Object[] items;
    private int count;

    public MyList() {
        items = new Object[10];
        count = 0;
    }

    @Override
    public void add(T item) {
        // Если массив полный, увеличиваем его
        if (count == items.length) {
            Object[] newArray = new Object[items.length * 2];
            for (int i = 0; i < count; i++) {
                newArray[i] = items[i];
            }
            items = newArray;
        }
        items[count] = item;
        count++;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Неверный индекс: " + index);
        }
        return (T) items[index];
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public Iterator<T> iterator() {
        return new SimpleIterator();
    }

    // Внутренний класс итератора
    private class SimpleIterator implements Iterator<T> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < count;
        }

        @Override
        @SuppressWarnings("unchecked")
        public T next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            return (T) items[currentIndex++];
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < count; i++) {
            sb.append(items[i]);
            if (i < count - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}