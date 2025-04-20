package com.shop.product;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import com.shop.product.domain.Product;
import com.shop.product.domain.ProductRepository;

@SpringBootApplication
public class Application {
	
	@Profile("dev")  // 1-1. dev 일때만 동작
	@Bean
	CommandLineRunner init(ProductRepository productRepository) {  // 1-2. 아래 main이 실행될 때 반드시 한번 실행된다
		return args -> {
			
			Product product1 = new Product(null, "바나나", 1000);
			Product product2 = new Product(null, "딸기", 2000);
			Product product3 = new Product(null, "사과", 3000);
			
			productRepository.save(product1);
			productRepository.save(product2);
			productRepository.save(product3);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
