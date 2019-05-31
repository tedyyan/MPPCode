package prob1.duck;

import prob1.fly.CannotFly;

import prob1.quack.MuteQuack;

public class DecoyDuck extends Duck {

    public DecoyDuck() {
        this.flyBehavior = new CannotFly();
        this.quackBehavior = new MuteQuack();
    }

    @Override
    public void display() {
        System.out.println("displaying");
    }
}
