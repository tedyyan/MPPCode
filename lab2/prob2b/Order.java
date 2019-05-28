class Order{
	private Long orderNum;
	private String orderDate;
	private OrderLine orderLine;

	public Order(OrderLine orderLine){
		this.orderLine = orderLine;
	}

	public Long getOrderNum(){
		return orderNum;
	}
	public void setOrderNum(Long orderNum){
		this.orderNum = orderNum;
	}
	public String getOrderDate(){
		return orderDate;
	}
	public void setOrderDate(String orderDate){
		this.orderDate = orderDate;
	}
}
