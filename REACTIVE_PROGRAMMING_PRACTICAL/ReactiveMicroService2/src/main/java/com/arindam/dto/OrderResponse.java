package com.arindam.dto;

public class OrderResponse {
private String pname;
private Integer pqty;
private Double price;
private Double total;
public OrderResponse() {
	super();
	// TODO Auto-generated constructor stub
}
public OrderResponse(String pname, Integer pqty, Double price, Double total) {
	super();
	this.pname = pname;
	this.pqty = pqty;
	this.price = price;
	this.total = total;
}
public String getPname() {
	return pname;
}
public void setPname(String pname) {
	this.pname = pname;
}
public Integer getPqty() {
	return pqty;
}
public void setPqty(Integer pqty) {
	this.pqty = pqty;
}
public Double getPrice() {
	return price;
}
public void setPrice(Double price) {
	this.price = price;
}
public Double getTotal() {
	return total;
}
public void setTotal(Double total) {
	this.total = total;
}
@Override
public String toString() {
	return "OrderResponse [pname=" + pname + ", pqty=" + pqty + ", price=" + price + ", total=" + total + "]";
}

}
