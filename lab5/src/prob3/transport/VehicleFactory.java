package prob3.transport;


public class VehicleFactory {
	
	private static final VehicleFactory instance= new VehicleFactory();
	public static VehicleFactory getInstance() {
		return instance;
	}
	
	public Vehicle getVehicle(String type) {
		Vehicle pizza = null;
		if (type.equals("Bus")) {
			pizza = new Bus();
		} else if (type.equals("Car")) {
			pizza = new Car();
		} else if (type.equals("Truck")) {
			pizza = new Truck();
		} else if (type.equals("ElectricCar")) {
			pizza = new ElectricCar();
		}
		return pizza;
	}	
}
