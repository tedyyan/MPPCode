package prob1.duck;

import prob1.fly.FlyWithWings;
import prob1.quack.Quack;

public class RedheadDuck extends Duck{
    public RedheadDuck() {
        this.flyBehavior = new FlyWithWings();
        this.quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("displaying");
    }
}
