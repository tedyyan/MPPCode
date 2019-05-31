package prob3;

import prob3.transport.VehicleFactory;

public class Main {
	public static void main(String[] args) {
		VehicleFactory factory  = VehicleFactory.getInstance();
		factory.getVehicle("Bus").startEngine();
		factory.getVehicle("Car").startEngine();
		factory.getVehicle("Truck").startEngine();
		factory.getVehicle("ElectricCar").startEngine();
	}
}
