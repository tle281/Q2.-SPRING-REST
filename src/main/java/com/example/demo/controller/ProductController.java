package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;

@RestController
public class ProductController {

	@Autowired
	ProductRepository productRepository;

	@GetMapping("/products/filter/price/{initial_range}/{final_range}")
	public ResponseEntity<List<Product>> getProductsWithPriceBetweenRange(@PathVariable long initial_range,
			@PathVariable long final_range) {
		try {
			List<Product> products = new ArrayList<Product>();

			productRepository.findByPriceBetween(initial_range, final_range).forEach(products::add);

			if (products.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}

			return new ResponseEntity<>(products, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/products/sort/price")
	public ResponseEntity<List<Product>> getProductsWithPriceSorted() {
		try {
			List<Product> products = productRepository.findAllByOrderByPriceAsc();

			if (products.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(products, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}