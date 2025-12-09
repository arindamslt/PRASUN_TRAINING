package com.arindam.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table

public class Product {
	@Id
private Integer pid;
private String pname;
private Double price;
public Product() {
	super();
	// TODO Auto-generated constructor stub
}
public Product(Integer pid, String pname, Double price) {
	super();
	this.pid = pid;
	this.pname = pname;
	this.price = price;
}
public Integer getPid() {
	return pid;
}
public void setPid(Integer pid) {
	this.pid = pid;
}
public String getPname() {
	return pname;
}
public void setPname(String pname) {
	this.pname = pname;
}
public Double getPrice() {
	return price;
}
public void setPrice(Double price) {
	this.price = price;
}
@Override
public String toString() {
	return "Product [pid=" + pid + ", pname=" + pname + ", price=" + price + "]";
}

}
