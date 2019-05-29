package lesson3.labs.prob3A;

public class Cylinder {
    private double height;
    private double radius;

    public Cylinder(double radius, double height) {
        this.height = height;
        this.radius = radius;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double computeVolume() {
        return Math.PI * radius * radius * height;
    }
}
