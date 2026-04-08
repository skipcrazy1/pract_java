package pract7.math;

public class MathFunc implements MathCalculate {

    @Override
    public double pow(double a, double b) {
        return Math.pow(a, b);
    }

    @Override
    public double complexAbs(double real, double imag) {
        return Math.sqrt(real * real + imag * imag);
    }

    public double circleLength(double r) {
        return 2 * PI * r;
    }
}
