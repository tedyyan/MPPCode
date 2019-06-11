package lesson7.labs.prob3.quack;

public interface Quackable {
    
    default void muteQuack() {
    	System.out.println("cannot quack");
    }
    default void quack() {
    	System.out.println("quacking");
    }
    default void squeak() {
    	System.out.println("squeaking");
    }
}

