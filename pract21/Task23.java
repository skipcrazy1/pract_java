package pract21;

public class Task23 {
    public static class GenericArray<T> {
        private T[] array;

        public GenericArray(T[] array) {
            this.array = array;
        }

        public T getElement(int index) {
            return array[index];
        }
    }

    public static void main(String[] args) {
        Integer[] intArray = {10, 20, 30, 40};
        String[] strArray = {"A", "B", "C"};

        GenericArray<Integer> intContainer = new GenericArray<>(intArray);
        GenericArray<String> strContainer = new GenericArray<>(strArray);

        System.out.println("intContainer[1]: " + intContainer.getElement(1));
        System.out.println("strContainer[0]: " + strContainer.getElement(0));
    }
}