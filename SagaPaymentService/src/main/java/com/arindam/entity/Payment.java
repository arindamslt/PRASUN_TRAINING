package com.arindam.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="payment_dtls")
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;
private Integer orderId;
private Double amount;
@Column(length = 25)
private String status;
public Payment() {
	super();
	// TODO Auto-generated constructor stub
}
public Payment(Integer id, Integer orderId, Double amount, String status) {
	super();
	this.id = id;
	this.orderId = orderId;
	this.amount = amount;
	this.status = status;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public Integer getOrderId() {
	return orderId;
}
public void setOrderId(Integer orderId) {
	this.orderId = orderId;
}
public Double getAmount() {
	return amount;
}
public void setAmount(Double amount) {
	this.amount = amount;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
@Override
public String toString() {
	return "Payment [id=" + id + ", orderId=" + orderId + ", amount=" + amount + ", status=" + status + "]";
}

}
