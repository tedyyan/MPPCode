package lab5.prob2;

public final class Rectangle implements Figure{

	
	private final double width;
	private final double length;
	
	public Rectangle(double width, double length) {
		this.width = width;
		this.length = length;
	}

	@Override
	public double computeArea() {
		// TODO Auto-generated method stub
		return width * length;
	}
	
	public double getWidth() {
		return width;
	}
	public double getLength() {
		return length;
	}
}
