package com.products.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.products.entity.Products;

@Repository
public interface ProductsRepository extends MongoRepository<Products, ObjectId>  {
	
   public Products findById(Long id);

}
