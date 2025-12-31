package com.arindam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arindam.entity.Payment;
import com.arindam.repository.PaymentRepository;

@Service
public class PaymentService {
	@Autowired
private PaymentRepository prepo;
	public void reserve(Integer orderId,Double amount)
	{
		if(amount>50000.00)
		{
			throw new RuntimeException("AMOUNT EXCEDDED");
		}
		Payment payment=new Payment();
		payment.setOrderId(orderId);
		payment.setAmount(amount);
		payment.setStatus("RESERVED");
		prepo.save(payment);
	}
	public void cancel(Integer orderId)
	{
		Payment payment=prepo.findByOrderId(orderId).orElseThrow();
		payment.setStatus("CANCELLED");
		prepo.save(payment);
	}
}
