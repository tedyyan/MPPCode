package mpp.lab2.prob2;

public class Main {

	public static void main(String[] args) {
		Building building1 = new Building(100);
		building1.addApartment(1000);
		building1.addApartment(2000);
		building1.addApartment(3000);
		
		
		Building building2 = new Building(500);
		building2.addApartment(1000);
		building2.addApartment(2000);
		building2.addApartment(2500);
		
		
		LandLord landLord = new LandLord();
		landLord.addBuild(building1);
		landLord.addBuild(building2);
		double monthlyProfit = landLord.monthlyProfit();
		System.out.println("landlord monthly profit is :" + monthlyProfit);
	}
}
