package lesson7.labs.prob3.duck;


public class RubberDuck extends Duck {


    @Override
    public void fly() {
    	// TODO Auto-generated method stub
    	super.notfly();
    }
    @Override
    public void quack() {
    	// TODO Auto-generated method stub
    	super.squeak();
    }
    @Override
    public void display() {
        System.out.println("displaying");
    }
}
