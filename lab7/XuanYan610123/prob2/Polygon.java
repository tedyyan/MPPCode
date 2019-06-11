package prob2;

public interface Polygon extends ClosedCurve{

	@Override
	default double computePerimeter() {
		double[] sides = getLengths();
		double perimeter = 0;
		for(double side : sides) {
			perimeter+=side;
		}
		return perimeter;
	}
	public double[] getLengths();
}
