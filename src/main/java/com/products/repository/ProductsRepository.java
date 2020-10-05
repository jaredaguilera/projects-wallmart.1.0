package com.products.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.products.entity.Products;

@Repository
public interface ProductsRepository extends MongoRepository<Products, ObjectId>  {
	
   public List<Products> findById(Long id);

}
