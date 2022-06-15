package com.hexaware.service;

import java.util.List;

import com.hexaware.entity.model.ProductDto;

public interface ProductService {

	public List<ProductDto> getAllProducts();

	public ProductDto getProductByName(String name);

	public ProductDto getProductByProductId(Integer productId);

	public List<ProductDto> getProductByRange(Float price);

	public void  deleteByProductId(Integer productId);
}
