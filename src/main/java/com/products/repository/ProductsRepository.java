package com.products.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.products.entity.Products;

@Repository
public interface ProductsRepository extends MongoRepository<Products, Long>  {
	
   Optional<Products> findById(Long id);

   Optional<Products> findByDescriptionOrBrand(String brand, String description);
   
}
