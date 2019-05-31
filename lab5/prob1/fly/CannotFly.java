package prob1.fly;

public class CannotFly implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("cannot prob1.fly");
    }
}
