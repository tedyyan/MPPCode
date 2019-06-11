package prob3.duck;

import prob3.fly.FlyWithWings;
import prob3.quack.Quack;

public class RedheadDuck implements Duck, Quack, FlyWithWings{
    public RedheadDuck() {
    
    }

    @Override
    public void display() {
        System.out.println("displaying");
    }
}
