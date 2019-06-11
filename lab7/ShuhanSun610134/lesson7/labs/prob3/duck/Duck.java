package lesson7.labs.prob3.duck;

import lesson7.labs.prob3.fly.Flyable;
import lesson7.labs.prob3.quack.Quackable;

public abstract class Duck implements Flyable, Quackable{
    
    public abstract void display();

    public void swim() {
        System.out.println("swimming");
    }

    public void fly() {
        Flyable.super.fly();
    }

    public void quack() {
    	Quackable.super.quack();
    }
}
