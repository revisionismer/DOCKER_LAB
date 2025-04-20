package com.shop.product.web.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.product.domain.Product;
import com.shop.product.domain.ProductRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class ProductApiController {

	private final ProductRepository productRepository;
	
	@GetMapping("/products")
	public ResponseEntity<?> products() {
		
		List<Product> products = productRepository.findAll();
		
		return new ResponseEntity<>(products, HttpStatus.OK);
	}
}
