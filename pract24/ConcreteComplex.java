package pract24;

public class ConcreteComplex implements Complex {
    private int real, imaginary;
    public ConcreteComplex(int r, int i) { real = r; imaginary = i; }
    public int getReal() { return real; }
    public int getImaginary() { return imaginary; }
    public String toString() { return real + (imaginary >= 0 ? "+" : "") + imaginary + "i"; }
}