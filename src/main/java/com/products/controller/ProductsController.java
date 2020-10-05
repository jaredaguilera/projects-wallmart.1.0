package com.products.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.products.entity.Products;
import com.products.service.ProductsService;

@RestController
@RequestMapping("/products/")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductsController {
	
	@Autowired
	private ProductsService productsService;
	
	
	@GetMapping("/getproducts")
	public List<Products> getProducts(){
		return productsService.findAll();
	}

	@GetMapping("/getproductsbyid/{id}")
	public List<Products> getProductsById (@PathVariable("id") String id){
		final Long idParse = Long.parseLong(id);
		System.out.println(idParse);
		return productsService.findById(idParse);
	}

	@GetMapping("/getproductsbybrand/{name}")
	public List<Products> getProductsByBrand (@PathVariable("name") String name){
		System.out.println(name);
		return productsService.getProductsByBrand(name);
	}
}
