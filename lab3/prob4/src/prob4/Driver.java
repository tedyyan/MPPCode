package prob4;

import prob4.properties.Address;
import prob4.properties.Condo;
import prob4.properties.House;
import prob4.properties.Property;
import prob4.properties.Trailer;

public class Driver {

	public static void main(String[] args) {
		Address houseAddr = new Address("FareFeild","North 4th Street 1000","IOWA","52557");
		Address connAddr = new Address("FareFeild","North 2th Street 2000","IOWA","52556");
		Address trailerAddr = new Address("FareFeild","North 1th Street 3000","IOWA","52556");
		Property[] objects = { new House(9000,houseAddr), new Condo(2,connAddr), new Trailer(trailerAddr) };
		double totalRent = Admin.computeTotalRent(objects);
		System.out.println(totalRent);
	}
}
