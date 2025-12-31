package com.arindam.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="product_dtls")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;
	@Column(length = 25)
private String pcode;
private Integer pqty;
private Double amount;
public Product() {
	super();
	// TODO Auto-generated constructor stub
}
public Product(Integer id, String pcode, Integer pqty, Double amount) {
	super();
	this.id = id;
	this.pcode = pcode;
	this.pqty = pqty;
	this.amount = amount;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getPcode() {
	return pcode;
}
public void setPcode(String pcode) {
	this.pcode = pcode;
}
public Integer getPqty() {
	return pqty;
}
public void setPqty(Integer pqty) {
	this.pqty = pqty;
}
public Double getAmount() {
	return amount;
}
public void setAmount(Double amount) {
	this.amount = amount;
}
@Override
public String toString() {
	return "Product [id=" + id + ", pcode=" + pcode + ", pqty=" + pqty + ", amount=" + amount + "]";
}

}
