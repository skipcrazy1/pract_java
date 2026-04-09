package pract9;

public class TestNumberBox {

    public static void main(String[] args) {

        NumberBox a = new NumberBox(10);
        NumberBox b = new NumberBox(3);

        if (a.compareTo(b) > 0)
            System.out.println(a + " > " + b);
        else if (a.compareTo(b) < 0)
            System.out.println(a + " < " + b);
        else
            System.out.println(a + " = " + b);
    }
}
