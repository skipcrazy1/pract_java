package pract2.zad3;

public class Circle {
    private Point center;
    private double rad;

    public Circle(Point center, double rad){
        this.center = center;
        this.rad = rad;
    }

    public Point getCenter()
    {
        return center;
    }
    public void setCenter(Point center){
        this.center = center;
    }
    public double getRad(){
        return rad;
    }
    public void setRad(double rad){
        this.rad = rad;
    }

    @Override
    public String toString(){
        return "Circle{" +
                "center=" + center +
                ", rad=" + rad +
                "}";
    }
}
