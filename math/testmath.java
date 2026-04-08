package pract7.math;

public class testmath{
    public static void main(String[] args) {

        MathCalculate calc = new MathFunc();

        System.out.println(calc.pow(2, 5));
        System.out.println(calc.complexAbs(3, 4));

        MathFunc mf = new MathFunc();
        System.out.println(mf.circleLength(10));
    }
}