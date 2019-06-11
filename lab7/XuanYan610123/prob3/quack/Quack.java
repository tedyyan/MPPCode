package prob3.quack;

public interface Quack extends QuackBehavior{
 
    default void quack() {
        System.out.println("quacking");
    }
}
