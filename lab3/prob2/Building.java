package mpp.lab2.prob2;

import java.util.ArrayList;
import java.util.List;

public class Building {

	List<Apartment> apartments = new ArrayList<Apartment>();
	
	private double maintenance;
	
	Building(double maintenance) {
		// TODO Auto-generated constructor stub
		this.maintenance = maintenance;
	}
	
	void addApartment(double rent) {
		Apartment apartment = new Apartment(rent);
		apartments.add(apartment);
	}
	
	public double calcProfit() {
		double sum = -maintenance;
		for (Apartment apartment : apartments) {
			sum += apartment.getRent();
		}
		return sum;
	}
	
}
