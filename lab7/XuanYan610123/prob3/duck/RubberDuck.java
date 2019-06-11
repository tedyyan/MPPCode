package prob3.duck;

import prob3.quack.Squeak;

public class RubberDuck  implements Duck,Squeak {
    public RubberDuck() {
     
    }

    @Override
    public void display() {
        System.out.println("displaying");
    }
}
