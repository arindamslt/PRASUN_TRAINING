package com.arindam.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

import com.arindam.model.Product;
@Repository
public interface ProductRepository extends R2dbcRepository<Product, Integer> {

}
