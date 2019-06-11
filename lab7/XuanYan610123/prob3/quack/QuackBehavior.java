package prob3.quack;

public interface QuackBehavior {
	default void quack() {
        System.out.println("cannot prob1.quack");
    }
}
