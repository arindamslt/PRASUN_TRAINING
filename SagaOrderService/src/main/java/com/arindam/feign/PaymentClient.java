package com.arindam.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name="payment-service",url="http://localhost:8082")
public interface PaymentClient {
	@PostMapping("/payment/reserve/{orderId}/{amount}")
	void reserve(@PathVariable Integer orderId,@PathVariable Double amount);
	@PostMapping("/payment/cancel/{orderId}")
	void cancel(@PathVariable Integer orderId);
}
