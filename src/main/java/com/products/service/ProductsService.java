package com.products.service;

import java.util.List;
import java.util.Optional;

import com.products.entity.Products;

public interface ProductsService {

	public List<Products> findAll();
	
	public Optional<Products> findById(Long id);
	
	public Optional<Products> findByDescriptionOrBrand(String brand, String description);

}
