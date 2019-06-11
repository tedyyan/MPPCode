package lesson7.labs.prob2.intfaces2;



public class Rectangle implements Polygon {
	private double length, width;
	public Rectangle(double length, double width) {
		this.length = length;
		this.width = width;
	}
	
	
	public double getLength() {
		return length;
	}
	public void setLength(double length) {
		this.length = length;
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}


	@Override
	public double[] getSides() {
		// TODO Auto-generated method stub
		return new double[] {length, width, length, width};
	}
}
