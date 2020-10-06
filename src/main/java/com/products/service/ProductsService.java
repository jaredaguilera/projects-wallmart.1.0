package com.products.service;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.products.entity.Products;

public interface ProductsService {

	public ResponseEntity<List<Products>> findAll() throws IOException;
	
	public ResponseEntity<Products> findById(Long id) throws IOException;

}
