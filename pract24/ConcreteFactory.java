package pract24;

public class ConcreteFactory implements CompexAbstractFactory {
    public Complex createComplex() { return new ConcreteComplex(0, 0); }
    public Complex createComplex(int r, int i) { return new ConcreteComplex(r, i); }
}