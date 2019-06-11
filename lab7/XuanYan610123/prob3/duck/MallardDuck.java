package prob3.duck;

import prob3.fly.FlyWithWings;
import prob3.quack.Quack;

public class MallardDuck implements Duck, Quack, FlyWithWings{
    public MallardDuck() {
       
    }

    @Override
    public void display() {
        System.out.println("displaying");
    }
}
