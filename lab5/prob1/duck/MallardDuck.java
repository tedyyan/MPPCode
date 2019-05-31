package prob1.duck;

import prob1.fly.FlyWithWings;
import prob1.quack.Quack;

public class MallardDuck extends Duck{
    public MallardDuck() {
        this.flyBehavior = new FlyWithWings();
        this.quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("displaying");
    }
}
