package lesson7.labs.prob3.fly;

public interface Flyable {
    default void fly() {
    	System.out.println("fly with wings");
    };
    default void notfly() {
        System.out.println("cannot fly");
    }
}
