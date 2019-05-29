package lesson3.labs.prob3A;

import lesson3.labs.prob3A.Cylinder;

public class Circle extends Cylinder {

    public Circle(double radius) {
        super(radius, 0);
    }

    @Override
    public double getRadius() {
        return super.getRadius();
    }

    public double computeArea() {
        return Math.PI * this.getRadius() * this.getRadius();
    }
}
