package pract7.string;

public class ProcessStrings implements StringOperations {

    @Override
    public int countChars(String s) {
        return s.length();
    }

    @Override
    public String oddPositions(String s) {
        StringBuilder sb = new StringBuilder(); //Это специальный объект для быстрого формирования новых строк.
        for (int i = 0; i < s.length(); i += 2) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    @Override
    public String invert(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}
