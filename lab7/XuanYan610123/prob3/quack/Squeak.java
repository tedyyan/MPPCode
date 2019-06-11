package prob3.quack;

public interface Squeak extends QuackBehavior{
    @Override
    default void quack() {
        System.out.println("squeaking");
    }
}
