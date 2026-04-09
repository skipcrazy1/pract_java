package pract9;

public class NumberBox implements Comparable<NumberBox> {

    private int number;

    public NumberBox(int number) {
        this.number = number;
    }

    @Override
    public int compareTo(NumberBox other) {
        return this.number - other.number;
    }

    @Override
    public String toString() {
        return "Number: " + number;
    }
}
