package mpp.lab2.prob2b;

import java.util.LinkedList;
import java.util.List;

public class OrderLine {

	private Integer linenum;
	private Integer price;
	private Integer quatity;
	private List<Order> orders;

	public OrderLine(Order order){
		this.orders = new LinkedList();
		addOrder(order);
	}

	public void addOrder(Order order){
		this.orders.add(order);
	}

	public Integer getLinenum(){
		return linenum;
	}
	public void setLinenum(Integer linenum){
		this.linenum = linenum;
	}
	public Integer getPrice(){
		return price;
	}
	public void setPrice(Integer price){
		this.price = price;
	}
	public Integer getQuatity(){
		return quatity;
	}
	public void setQuatity(Integer quatity){
		this.quatity = quatity;
	}
}
