package com.hexaware.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Product {
	
	public Product() {};
	public Product(Integer productId, String name, String brand, Float price) {
		this.productId = productId;
		this.name = name;
		this.brand = brand;
		this.price = price;
	}
	
	@Id
	@Column(name="product_id")
	private Integer productId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="brand")
	private String brand;
	
	@Column(name="price")
	private Float price;

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	
}
