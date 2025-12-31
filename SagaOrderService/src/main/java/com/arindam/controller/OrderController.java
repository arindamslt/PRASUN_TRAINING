package com.arindam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arindam.entity.Order;
import com.arindam.service.SagaService;

@RestController
@RequestMapping("/order")
public class OrderController {
	@Autowired
private SagaService sservice;
	@PostMapping
	public String startSaga(@RequestBody Order order)
	{
		sservice.startSaga(order);
		return "SAGA STARTED";
	}
}
