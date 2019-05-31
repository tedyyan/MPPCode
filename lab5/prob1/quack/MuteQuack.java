package prob1.quack;

public class MuteQuack implements QuackBehavior{
    @Override
    public void quack() {
        System.out.println("cannot prob1.quack");
    }
}
