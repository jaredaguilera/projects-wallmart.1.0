package com.products.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.products.entity.Products;
import com.products.exceptions.ProductsException;
import com.products.repository.ProductsRepository;

@Service
public class ProductsServiceImpl implements ProductsService {

	@Autowired
	private ProductsRepository productsRepository;
	

	@Override
	@Transactional(readOnly = true)
	public List<Products> findAll(){
		List<Products> productsList = new ArrayList<Products>();
		try {
			productsList = productsRepository.findAll();
		} catch (ProductsException e) {
			throw new ProductsException(e.getMessage());
		}
		return productsList;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Products> findById(Long id){
		Products product = new Products();
		List<Products> productsList = new ArrayList<Products>();
		try {
			product = productsRepository.findById(id);
			if (product != null) {
				productsList.add(product);
			}
		} catch (ProductsException e) {
			throw new ProductsException(e.getMessage());
		}
		return productsList;
	}

}
