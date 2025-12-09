package com.arindam.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arindam.model.Product;
import com.arindam.service.ProductService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/product")
public class ProductController {
private ProductService pservice;
public ProductController(ProductService pservice)
{
	this.pservice=pservice;
}
@PostMapping("/add")
public Mono<ResponseEntity<Product>> addData(@RequestBody Product p)
{
	return pservice.addData(p)
			.map(ps->ResponseEntity.status(HttpStatus.CREATED).body(ps));
}
@GetMapping("/fetch")
public Flux<Product> getData()
{
	return pservice.getData();
}
@GetMapping("/fetch/{pid}")
public Mono<ResponseEntity<Product>> getPidDetails(@PathVariable Integer pid)
{
	return pservice.getPidDetails(pid)
			.map(ps->ResponseEntity.status(HttpStatus.OK).body(ps));
}
@DeleteMapping("/del/{pid}")
public Mono<ResponseEntity<String>> deletedata(@PathVariable Integer pid)
{
	return pservice.deleteData(pid)
			.map(msg->ResponseEntity.status(HttpStatus.OK).body(msg))
			.onErrorResume(ex->Mono.just(ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage())));
}
@PutMapping("/upd/{pid}")
public Mono<ResponseEntity<Product>> updateData(@PathVariable Integer pid,@RequestBody Product p)
{
	return pservice.updateData(pid, p)
			.map(ps->ResponseEntity.status(HttpStatus.OK).body(ps));	
}
}
