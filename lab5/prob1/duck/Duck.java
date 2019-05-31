package prob1.duck;

import prob1.fly.FlyBehavior;
import prob1.quack.QuackBehavior;

public abstract class Duck {
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public abstract void display();

    public void swim() {
        System.out.println("swimming");
    }

    public void fly() {
        flyBehavior.fly();
    }

    public void quack() {
        quackBehavior.quack();
    }
}
