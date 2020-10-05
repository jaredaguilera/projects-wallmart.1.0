package com.products.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.products.entity.Products;
import com.products.repository.ProductsRepository;

@Service
public class ProductsServiceImpl implements ProductsService {
	
	@Autowired
	private ProductsRepository productsRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Products> findAll() {
		return productsRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Products> findById(Long id) {
		return productsRepository.findById(id);
	}

}
