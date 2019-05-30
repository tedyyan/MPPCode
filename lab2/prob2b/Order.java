import java.util.LinkedList;
import java.util.List;

class Order{
	
	private Long orderNum;
	private String orderDate;
	private List<OrderLine> orderLines;

	public Order() {
		this.orderLines = new LinkedList<OrderLine>();
	}

	public void addOrderLine(Integer linenum, Integer price, Integer quatity) {
		OrderLine orderLine = new OrderLine(this);
		orderLine.setLinenum(linenum);
		orderLine.setPrice(price);
		orderLine.setQuatity(quatity);
		orderLines.add(orderLine);
	}

	public Long getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Long orderNum) {
		this.orderNum = orderNum;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public List<OrderLine> getOrderLines() {
		return orderLines;
	}
}
