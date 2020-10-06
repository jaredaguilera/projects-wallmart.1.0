package com.products.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<List<Products>> findAll() throws IOException {
		List<Products> productsList = new ArrayList<Products>();
		ResponseEntity<List<Products>> refundEntity = new ResponseEntity<List<Products>>(HttpStatus.OK);
		try {
			productsList = productsRepository.findAll();
			refundEntity = new ResponseEntity<List<Products>>(productsList,HttpStatus.OK);
		} catch (ProductsException e) {
			throw new ProductsException(e.getMessage());
		}
		return refundEntity;
	}

	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<Products> findById(Long id) throws IOException  {
		Products product = new Products();
		ResponseEntity<Products> refundEntity = new ResponseEntity<Products>(HttpStatus.OK);
		try {
			product = productsRepository.findById(id);
			refundEntity = new ResponseEntity<Products>(product,HttpStatus.OK);
		} catch (ProductsException e) {
			throw new ProductsException(e.getMessage());
		}
		return refundEntity;
	}

}
