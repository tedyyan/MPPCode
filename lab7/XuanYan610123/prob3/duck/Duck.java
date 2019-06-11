package prob3.duck;

import prob3.fly.FlyBehavior;
import prob3.quack.QuackBehavior;

public interface Duck extends QuackBehavior, FlyBehavior{


    public abstract void display();

    default void swim() {
        System.out.println("swimming");
    }

}
