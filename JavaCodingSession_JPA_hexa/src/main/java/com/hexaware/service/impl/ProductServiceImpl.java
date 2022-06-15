package com.hexaware.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.entity.Product;
import com.hexaware.entity.model.ProductDto;
import com.hexaware.repository.ProductRepository;
import com.hexaware.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	ModelMapper modelMapper = new ModelMapper();

	@Override
	public List<ProductDto> getAllProducts() {

		return productRepository.findAll()
				.stream()
				.map(product -> modelMapper.map(product, ProductDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public ProductDto getProductByName(String name) {


		Product product = productRepository.findByName(name);

		if(product == null)
			return null;
		else
			return modelMapper.map(product, ProductDto.class);

	}

	@Override
	public ProductDto getProductByProductId(Integer productId) {
		Optional<Product> product = productRepository.findById(productId);

		if(product == null)
			return null;
		else
			return modelMapper.map(product.get(), ProductDto.class);
	}

	@Override
	public List<ProductDto> getProductByRange(Float price) {
		return productRepository.findByPriceLessThanEqual(price)
				.stream()
				.map(product -> modelMapper.map(product, ProductDto.class))
				.collect(Collectors.toList());
		
	}

	@Override
	public void deleteByProductId(Integer productId) {
		
		if(productRepository.existsById(productId))
			productRepository.deleteById(productId);
		
	}

}
