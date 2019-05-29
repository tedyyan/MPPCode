package prob4.properties;

public class House extends Property{
	private double rent = RentConstValue.HouseRent;
	private double lotsize = 0;
	private Address address;
	
	public House(double lotsize,Address addr){
		this.lotsize = lotsize;
		this.address = addr;
	}
	@Override
	public double computeRent() {
		return rent * lotsize;
	}

	public double getRent() {
		return rent;
	}
	public double getLotsize() {
		return lotsize;
	}
	public Address getAddress() {
		return address;
	}
	@Override
	public String toString() {
		return "House address:"+address+"\r\n        lotsize: "+ lotsize + " rent: "+rent + " total rent:" + computeRent();
	}
	
	
}
