package prob1.duck;

import prob1.fly.CannotFly;
import prob1.quack.Squeak;

public class RubberDuck extends Duck {
    public RubberDuck() {
        this.flyBehavior = new CannotFly();
        this.quackBehavior = new Squeak();
    }

    @Override
    public void display() {
        System.out.println("displaying");
    }
}
