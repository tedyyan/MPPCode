package lesson5.labs.prob4;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CustomerAndOrderImpl implements CustomerAndOrder {
	private Customer customer = null;
	private List<Order> order = new ArrayList<Order>();
	
	CustomerAndOrderImpl(Customer customer){
		this.customer= customer;
	}
	@Override
	public Customer getCustomer() {
		return customer;
	}

	@Override
	public List<Order> getOrder() {
		return order;
	}
	
	@Override
	public void addOrder(LocalDate date, String[] items) {
		Order oneorder = Order.newOrder(customer, date);
		for(String item:items)
			oneorder.addItem(item);
		this.order.add(oneorder);
	}

}
