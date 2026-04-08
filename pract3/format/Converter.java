package pract3.format;

import java.text.DecimalFormat;

public class Converter {
    private static final double EUR = 0.85;
    private static final double GBP = 0.74;
    private static final double JPY = 147.70;
    private static final double RUB = 82.50;

    private DecimalFormat df = new DecimalFormat("#,##0.00"); //1,234,567.89

    private String eur;
    private String gbp;
    private String jpy;
    private String rub;



    public void convert(double usdAmount){
        this.eur = df.format(usdAmount * EUR);
        this.gbp = df.format(usdAmount * GBP);
        this.jpy = df.format(usdAmount * JPY);
        this.rub = df.format(usdAmount * RUB);
    }

    @Override
    public String toString() {
        return "Converter{" +
                "eur=" + eur +
                "; gbp=" + gbp +
                "; jpy=" + jpy +
                "; rub=" + rub +
                '}';
    }
}