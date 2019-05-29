package prob4.properties;

public class Address {
	private String  city;
	private String  street;
	private String  state;
	private String  zip;
	public Address(String city,String street,String state,String zip){
		this.city = city;
		this.street = street;
		this.state = state;
		this.zip = zip;
	}
	

	public String getCity() {
		return city;
	}
	public String getStreet() {
		return street;
	}
	public String getState() {
		return state;
	}
	public String getZip() {
		return zip;
	}
	@Override
	public String toString() {
		return "city: "+city+" street: "+ street + " state: "+state + " zip:" + zip;
	}
	
	
	
}
