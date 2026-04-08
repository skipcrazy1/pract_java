package pract6.zad11;

public class Celsius implements Convertable{
    private double celsius;
    public Celsius(double celsius){
        this.celsius = celsius;
    }

    @Override
    public double convert(){
        return celsius+ 273.13;
    }

    public double toFahrenheit(){
        return celsius*1.8+32;
    }

    public double toKelvin(){
        return convert();
    }

    public double getCelsius(){
        return celsius;
    }
}
