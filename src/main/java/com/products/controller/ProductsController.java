package com.products.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.products.entity.Products;
import com.products.exceptions.ProductsException;
import com.products.service.ProductsService;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@RequestMapping("/products/")
@CrossOrigin(origins = "http://localhost:4200")
@EnableSwagger2
public class ProductsController {
	
	@Autowired
	private ProductsService productsService;
	
	/**
	 * Busqueda completa de productos
	 */
	@GetMapping("/getproducts")
	public ResponseEntity<List<Products>> getProducts() throws IOException{
		return productsService.findAll();
		
	}
	
	/**
	 * Busqueda completa por ID productos
	 */
	@GetMapping("/getproductsbyid/{id}")
	public ResponseEntity<Products> getProductsById (@PathVariable("id") String id) throws IOException{
		try {
			final Long idParse = Long.parseLong(id);
			return productsService.findById(idParse);
		} catch (Exception e) {
			throw new ProductsException(e.getMessage());
		}
		
	}

}
