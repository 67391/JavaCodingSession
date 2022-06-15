package com.hexaware;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.hexaware.entity.Product;
import com.hexaware.repository.ProductRepository;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.hexaware")
public class SpringbootrestApplication implements CommandLineRunner {

	@Autowired
	ProductRepository productRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootrestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		productRepository.save(new Product(400,"Macbook","Apple",4060f));
		productRepository.save(new Product(401,"Iphone 10","Apple",1200f));
		productRepository.save(new Product(100,"Kindle Fire","Amazon",100f));
		productRepository.save(new Product(200,"inspiron 15","Dell",600f));
		productRepository.save(new Product(300,"Galaxy 10","Samsung",700f));
		productRepository.save(new Product(500,"Mazda 3","Honda",13000f));
	}

}
