package lesson7.labs.prob3.duck;


public class DecoyDuck extends Duck {

    @Override
    public void fly() {
		super.notfly();
	}
    @Override
    public void quack() {
    	super.muteQuack();
    }

    @Override
    public void display() {
        System.out.println("displaying");
    }
}
