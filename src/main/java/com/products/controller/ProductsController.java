package com.products.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.products.entity.Products;
import com.products.service.ProductsService;

@RestController
public class ProductsController {
	
	@Autowired
	private ProductsService productsService;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getproducts")
	public List<Products> getProducts (){
		return productsService.findAll();
	}

}
