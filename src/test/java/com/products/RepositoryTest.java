package com.products;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.products.repository.ProductsRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RepositoryTest {
	
	@Autowired
	ProductsRepository productsRepository;

	@Test
	public void findAllTest() {
		boolean result = productsRepository.findAll() != null;
		Assert.assertTrue(result);
	}
	
	@Test
	public void findByIdTest() {
		Long id = 3000L;
		System.out.println(id);
		boolean result = productsRepository.findById(id) != null;
		Assert.assertTrue(result);
	}
}
