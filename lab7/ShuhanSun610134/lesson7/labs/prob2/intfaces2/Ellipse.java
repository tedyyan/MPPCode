package lesson7.labs.prob2.intfaces2;

public class Ellipse implements ClosedCurve{

	private double semiMajorAxis;
	private double ellipIntegralAtEccentricity;
	
	public Ellipse(double semiMajorAxis, double ellipIntegralAtEccentricity) {
		// TODO Auto-generated constructor stub
		this.semiMajorAxis = semiMajorAxis;
		this.ellipIntegralAtEccentricity = ellipIntegralAtEccentricity;
	}

	@Override
	public double computePerimeter() {
		// TODO Auto-generated method stub
		return 4 * semiMajorAxis * ellipIntegralAtEccentricity;
	}
}
