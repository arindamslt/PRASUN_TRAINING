package com.arindam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arindam.entity.Order;
import com.arindam.repository.OrderRepository;

@Service
public class OrderService {
	@Autowired
private OrderRepository orepo;
public void createOrder(Order order)
{
	order.setStatus("CREATED");
	orepo.save(order);
}
public void updateStatus(Integer id,String status)
{
	Order order=orepo.findById(id).orElse(null);
	order.setStatus(status);
	orepo.save(order);
}
}
