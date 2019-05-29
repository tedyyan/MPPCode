package prob4.properties;

public class Trailer extends Property{
	double rent = RentConstValue.TrailerRent;
	private Address address;
	
	public Trailer(Address addr){
		this.address = addr;
	}
	@Override
	public double computeRent() {
		return rent;
	}
	public double getRent() {
		return rent;
	}
	public Address getAddress() {
		return address;
	}
	@Override
	public String toString() {
		return "Trailer address:"+address+"\r\n        rent: "+rent + " total rent:" + computeRent();
	}

}
