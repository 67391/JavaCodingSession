package com.hexaware.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.hexaware.entity.model.ProductDto;
import com.hexaware.service.ProductService;



@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping(path = "/getAllProducts")
	public ResponseEntity<List<ProductDto>> getAllProducts(){
		
		return ResponseEntity.ok(productService.getAllProducts());
	}
	
	@GetMapping(path = "/getProductByName")
	public ResponseEntity<ProductDto> getProductByName(@RequestParam("name")String name){
		
		return ResponseEntity.ok(productService.getProductByName(name));
	}
	
	@GetMapping(path = "/getProductByProductId")
	public ResponseEntity<ProductDto> getProductByProductId(@RequestParam("productId")Integer productId){
		
		return ResponseEntity.ok(productService.getProductByProductId(productId));
	}
	
	@GetMapping(path = "/getProductByRange")
	public ResponseEntity<List<ProductDto>> getProductByRange(@RequestParam("price")Float price){
		
		return ResponseEntity.ok(productService.getProductByRange(price));
	}
	
	
	@DeleteMapping(path = "/deleteByProductId")
	public ResponseEntity<List<ProductDto>> deleteByProductId(@RequestParam("productId")Integer productId){
		productService.deleteByProductId(productId);
		return ResponseEntity.ok(productService.getAllProducts());
	}
}
