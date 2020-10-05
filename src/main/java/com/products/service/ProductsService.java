package com.products.service;

import java.util.List;

import com.products.entity.Products;

public interface ProductsService {

	public List<Products> findAll();
	
	public List<Products> findById(Long id);

}
