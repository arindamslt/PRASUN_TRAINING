package com.arindam.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.arindam.dto.OrderRequest;
import com.arindam.dto.OrderResponse;
import com.arindam.model.Product;

import reactor.core.publisher.Mono;

@Service
public class OrderService {
private  WebClient client;
public OrderService(WebClient client)
{
	this.client=client;
}
public Mono<OrderResponse> placeOrder(OrderRequest req)
{
	 return client.get()
             .uri("/" + req.getPid())
             .retrieve()
             .bodyToMono(Product.class)
             .flatMap(product -> {

                 Double total = product.getPrice() * req.getPqty();

                 OrderResponse response = new OrderResponse(
                         product.getPname(),
                         req.getPqty(),
                         product.getPrice(),
                         
                         total
                 );

                 return Mono.just(response);
             })
             .switchIfEmpty(Mono.error(new RuntimeException("Invalid Product ID")));

}
}
