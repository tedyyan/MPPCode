package lesson7.labs.prob2.intfaces2;

public interface Polygon extends ClosedCurve {

	double[] getSides();

	default double computePerimeter() {
		double sum = 0;
		for (double i : getSides()) {
			sum += i;
		}
		return sum;
	}
}
