package com.arindam.dto;

public class OrderRequest {
private Integer pid;
private Integer pqty;
public OrderRequest() {
	super();
	// TODO Auto-generated constructor stub
}
public OrderRequest(Integer pid, Integer pqty) {
	super();
	this.pid = pid;
	this.pqty = pqty;
}
public Integer getPid() {
	return pid;
}
public void setPid(Integer pid) {
	this.pid = pid;
}
public Integer getPqty() {
	return pqty;
}
public void setPqty(Integer pqty) {
	this.pqty = pqty;
}
@Override
public String toString() {
	return "OrderRequest [pid=" + pid + ", pqty=" + pqty + "]";
}

}
