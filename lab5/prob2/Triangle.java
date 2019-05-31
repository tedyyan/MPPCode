package lab5.prob2;

public final class Triangle implements Figure{

	private final double base;
	private final double height;
	
	public Triangle(double base, double height) {
		this.base = base;
		this.height = height;
		// TODO Auto-generated constructor stub
	}

	@Override
	public double computeArea() {
		// TODO Auto-generated method stub
		return 0.5 * base * height;
	}
	public double getBase() {
		return base;
	}
	public double getHeight() {
		return height;
	}
}
