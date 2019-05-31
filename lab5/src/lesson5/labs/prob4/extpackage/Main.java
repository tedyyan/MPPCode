package lesson5.labs.prob4.extpackage;

import java.time.LocalDate;

import lesson5.labs.prob4.CustOrderFactory;
import lesson5.labs.prob4.CustomerAndOrder;

public class Main {
	public static void main(String[] args) {
		/*
		Customer cust = new Customer("Bob");
		Order order = Order.newOrder(cust, LocalDate.now());
		order.addItem("Shirt");
		order.addItem("Laptop");

		order = Order.newOrder(cust, LocalDate.now());
		order.addItem("Pants");
		order.addItem("Knife set");

		System.out.println(cust.getOrders());
		*/
		
		CustomerAndOrder a = CustOrderFactory.createCustomerAndOrderFactory("Bob");
		a.addOrder(LocalDate.now(), new String[]{"Shirt","Laptop"});
		a.addOrder(LocalDate.now(), new String[]{"Pants","Knife set"});

		System.out.println(a.getCustomer().getOrders());
	}
}

		
