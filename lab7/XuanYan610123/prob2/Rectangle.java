package prob2;

public class Rectangle implements Polygon {
	private double length, width;
	public Rectangle(double length, double width) {
		this.length = length;
		this.width = width;
	}
	
	

	@Override
	public double[] getLengths() {
		
		return new double[] {length,width,length,width};
	}
}
