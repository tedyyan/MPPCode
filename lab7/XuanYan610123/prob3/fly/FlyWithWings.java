package prob3.fly;

public interface FlyWithWings extends FlyBehavior {
    @Override
    default void fly() {
        System.out.println("prob1.fly with wings");
    }
}
