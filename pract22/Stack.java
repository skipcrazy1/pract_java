package pract22;

public class Stack {
    private double[] arr;
    private int top = -1;

    public Stack(int size) {
        arr = new double[size];
    }

    public void push(double x) {
        arr[++top] = x;
    }

    public double pop() {
        if (isEmpty()) throw new RuntimeException("Стек пуст");
        return arr[top--];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }
}