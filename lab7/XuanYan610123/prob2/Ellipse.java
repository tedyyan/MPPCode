package prob2;

public class Ellipse implements ClosedCurve{
	double semiMajorAxis;
	
	double ellipIntegralAtEccentricity;
	
	public Ellipse(double semiMajorAxis,double ellipIntegralAtEccentricity){
		this.semiMajorAxis = semiMajorAxis;
		this.ellipIntegralAtEccentricity = ellipIntegralAtEccentricity;
	}
	
	@Override
	public double computePerimeter() {
		
		return 4 * semiMajorAxis * ellipIntegralAtEccentricity;
	}

}
