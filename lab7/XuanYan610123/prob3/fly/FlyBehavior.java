package prob3.fly;

public interface FlyBehavior {
	 
    default void fly() {
        System.out.println("cannot prob1.fly");
    }
}
