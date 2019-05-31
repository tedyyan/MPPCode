package lab5.prob2;

public final class Circle implements Figure{

	private final double radius;
	private static final double PI = 3.14;
	
	public Circle(double radius) {
		this.radius = radius;
		// TODO Auto-generated constructor stub
	}

	@Override
	public double computeArea() {
		// TODO Auto-generated method stub
		return  PI * radius * radius;
	}
	public double getRadius() {
		return radius;
	}
}
