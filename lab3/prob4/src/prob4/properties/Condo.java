package prob4.properties;

public class Condo extends Property{
	private int numFloors;
	private double rent = RentConstValue.ConnRent;
	private Address address;

	public Condo(int numFloors,Address addr) {
		this.numFloors = numFloors;
		this.address = addr;
	}

	@Override
	public double computeRent() {
		
		return this.rent * this.numFloors;
	}

	public int getNumFloors() {
		return numFloors;
	}

	public double getRent() {
		return rent;
	}

	public Address getAddress() {
		return address;
	}
	@Override
	public String toString() {
		return "Condominium address:"+address+"\r\n        numFloors: "+ numFloors + " rent: "+rent + " total rent:" + computeRent();
	}
}
