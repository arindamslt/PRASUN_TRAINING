package com.arindam.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arindam.dto.OrderRequest;
import com.arindam.dto.OrderResponse;
import com.arindam.service.OrderService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/order")
public class OrderController {
private OrderService oservice;
public OrderController(OrderService oservice)
{
	this.oservice=oservice;
}
@PostMapping("/place")
public Mono<ResponseEntity<OrderResponse>> placeOrder(@RequestBody OrderRequest req)
{
	return oservice.placeOrder(req)
			.map(o->ResponseEntity.status(HttpStatus.CREATED).body(o));
}
}
