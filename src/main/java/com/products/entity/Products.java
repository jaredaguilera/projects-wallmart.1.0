package com.products.entity;

import java.io.Serializable;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
public class Products implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private ObjectId _id;
	private Long id;
	private String brand;
	private String description;
	private String image;
	private Double price;

	public Products() {
	}

	public Products(ObjectId _id, String brand, String description, String image, Double price) {
		this._id = _id;
		this.brand = brand;
		this.description = description;
		this.image = image;
		this.price = price;
	}

	public ObjectId get_id() {
		return _id;
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Products [_id=" + _id + ", id=" + id + ", brand=" + brand + ", description=" + description + ", image="
				+ image + ", price=" + price + "]";
	}

}