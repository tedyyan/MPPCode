package mpp.lab2.prob2;

import java.util.ArrayList;
import java.util.List;

public class LandLord {

	List<Building> buildings = new ArrayList<Building>();
	
	void addBuild(Building e) {
		buildings.add(e);
	}
	
	public double monthlyProfit(){
		double monthlyProfit = 0;
		for (Building building : buildings) {
			monthlyProfit += building.calcProfit();
		}
		return monthlyProfit;
	}
	
}
