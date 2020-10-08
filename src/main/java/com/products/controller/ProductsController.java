package com.products.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.products.entity.Products;
import com.products.exceptions.ProductsException;
import com.products.service.ProductsService;
import com.products.util.Utils;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@EnableSwagger2
@CrossOrigin(origins = "*", methods = RequestMethod.GET, maxAge = 3600)
@RequestMapping("/products/")
public class ProductsController {

	@Autowired
	private ProductsService productsService;

	/**
	 * Busqueda por ID productos
	 */
	@GetMapping(value = "/")
	public ResponseEntity<List<Products>> getProductsById(@RequestParam(required = false, defaultValue = "") String id,
			@RequestHeader("Access-Control-Allow-Origin") String access) {
		List<Products> listOutput = new ArrayList<Products>();
		try {
			if (id.equals(null) || id.equals("")) {
				listOutput = productsService.findAll();
			} else if (Utils.isNumeric(id)) {
				final Long idParse = Long.parseLong(id);
				listOutput = productsService.findById(idParse);
			} else {
				List<Products> listOfProducts = productsService.findAll();
				listOutput = listOfProducts.stream()
						.filter(e -> e.getBrand().contains(id) || e.getDescription().contains(id))
						.collect(Collectors.toList());
			}
			
			for (Products products : listOutput) {
				Double priceLowered = products.getPrice() * 0.5;
				products.setPriceLowered(priceLowered);
			}
		} catch (NumberFormatException e) {
			throw new ProductsException(e.getMessage());
		}
		return new ResponseEntity<List<Products>>(listOutput, HttpStatus.OK);
	}

}
