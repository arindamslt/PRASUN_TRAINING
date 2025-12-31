package com.arindam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arindam.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	@Autowired
private PaymentService pservice;
	@PostMapping("/reserve/{orderId}/{amount}")
	public String reserve(@PathVariable Integer orderId,@PathVariable Double amount)
	{
		pservice.reserve(orderId, amount);
		return "PAYMENT RESERVED";
	}
	@PostMapping("/cancel/{orderId}")
	public String cancel(@PathVariable Integer orderId)
	{
		pservice.cancel(orderId);
		return "PAYMENT CANCELlED";
	}
}

