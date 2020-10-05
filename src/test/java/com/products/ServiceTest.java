package com.products;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.products.service.ProductsService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTest {
	
	@Autowired
	ProductsService productsService;

	@Test
	public void findAllTest() {
		boolean result = productsService.findAll() != null;
		Assert.assertTrue(result);
	}
	
	@Test
	public void findByIdTest() {
		Long id = 200L;
		System.out.println(id);
		Assert.assertEquals(1,productsService.findById(id));
	}
}
