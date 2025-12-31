package com.arindam.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="inventory_dtls")
public class Inventory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;
	@Column(length = 25)
private String pcode;
private Integer avlqty;
private Integer resvqty;
public Inventory() {
	super();
	// TODO Auto-generated constructor stub
}
public Inventory(Integer id, String pcode, Integer avlqty, Integer resvqty) {
	super();
	this.id = id;
	this.pcode = pcode;
	this.avlqty = avlqty;
	this.resvqty = resvqty;
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
public Integer getAvlqty() {
	return avlqty;
}
public void setAvlqty(Integer avlqty) {
	this.avlqty = avlqty;
}
public Integer getResvqty() {
	return resvqty;
}
public void setResvqty(Integer resvqty) {
	this.resvqty = resvqty;
}
@Override
public String toString() {
	return "Inventory [id=" + id + ", pcode=" + pcode + ", avlqty=" + avlqty + ", resvqty=" + resvqty + "]";
}

}
