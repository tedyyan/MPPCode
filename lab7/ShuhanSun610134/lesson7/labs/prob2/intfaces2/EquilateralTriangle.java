package lesson7.labs.prob2.intfaces2;

public class EquilateralTriangle implements Polygon{

	private double side;

	public double getSide() {
		return side;
	}
	public void setSide(double side) {
		this.side = side;
	}
	public EquilateralTriangle(double side) {
		this.side = side;
	}
	@Override
	public double[] getSides() {
		// TODO Auto-generated method stub
		return new double[] {side, side, side};
	}
}
