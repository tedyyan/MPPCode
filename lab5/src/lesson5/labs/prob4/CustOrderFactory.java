package lesson5.labs.prob4;


final public class CustOrderFactory {
	private CustOrderFactory(){}
	
	public static CustomerAndOrder createCustomerAndOrderFactory(String customername) {
		Customer cust = new Customer(customername);
		CustomerAndOrder r = new CustomerAndOrderImpl(cust);
		return r;
		
	}
	
}
