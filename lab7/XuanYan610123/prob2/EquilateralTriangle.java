package prob2;

public class EquilateralTriangle implements Polygon{
	double sideLen;
	
	public double getSideLen() {
		return sideLen;
	}
	public void setSideLen(double sideLen) {
		this.sideLen = sideLen;
	}
	EquilateralTriangle(double sideLen){
		this.sideLen = sideLen;
	}
	@Override
	public double[] getLengths() {
		
		return new double[]{sideLen,sideLen,sideLen};
	}

}
