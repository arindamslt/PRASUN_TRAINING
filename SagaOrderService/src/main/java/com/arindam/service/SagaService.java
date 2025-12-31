package com.arindam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arindam.entity.Order;
import com.arindam.feign.InventoryClient;
import com.arindam.feign.PaymentClient;



@Service
public class SagaService {
	@Autowired
private OrderService oservice;
	@Autowired
private PaymentClient pClient;
	@Autowired
private InventoryClient invClient;
public void startSaga(Order order)
{
	boolean paymentDone=false;
	boolean inventoryDone=false;
	try
	{
		oservice.createOrder(order);
		System.out.println("AMOUNT:"+order.getAmount());
		pClient.reserve(order.getId(),order.getAmount());
		paymentDone=true;
		System.out.println(paymentDone);
		invClient.reserve(order.getPcode(),order.getPqty());
		inventoryDone=true;
	     oservice.updateStatus(order.getId(),"COMPLETED");
		
	}
	catch(Exception ex)
	{
		if(!paymentDone)
		{
			System.out.println("PAYMENT CANCELLED");
			oservice.updateStatus(order.getId(),"CANCELLED");
			pClient.cancel(order.getId());
		}
		if(inventoryDone)
		{
			oservice.updateStatus(order.getId(),"CANCELLED");
			pClient.cancel(order.getId());
			
		}
		//oservice.updateStatus(order.getId(),"CANCELLED");
	}
}
}
