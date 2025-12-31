package com.arindam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arindam.entity.Product;
import com.arindam.feign.InventoryClient;
import com.arindam.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
private ProductRepository prepo;
	@Autowired
private InventoryClient invClient;
	public void addProduct(Product product)
	{
		prepo.save(product);
		invClient.createInventory(product.getPcode(),product.getPqty());
	}
}
