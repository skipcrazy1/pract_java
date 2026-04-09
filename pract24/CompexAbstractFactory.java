package pract24;

public interface CompexAbstractFactory {
    //Создает комплексное число с нулевыми значениями

    Complex createComplex();

    //Создает комплексное число с заданными значениями
    Complex createComplex(int real, int image);
}