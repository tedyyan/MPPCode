package lesson5.labs.prob4;

import java.time.LocalDate;
import java.util.List;

public interface CustomerAndOrder {
	public Customer getCustomer();
	public List<Order> getOrder();
	public void addOrder( LocalDate date, String[] items);
	
}
