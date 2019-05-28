class Order{
	
	private Long orderNum;
	private String orderDate;
	private List<OrderLine> orderLines;

	public Order(){
		this.orderLines = new LinkedList<OrderLine>();
	}
	public void addOrderLine(OrderLine orderLine) {
		orderLines.add(orderLine);
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
	public List<OrderLine> getOrderLines(){
		return orderLines;
	}
}
