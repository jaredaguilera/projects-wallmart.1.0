package com.products.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.products.entity.Products;

public interface ProductsService {

	public ResponseEntity<List<Products>> findAll();
	
	public ResponseEntity<Products> findById(Long id);

}
