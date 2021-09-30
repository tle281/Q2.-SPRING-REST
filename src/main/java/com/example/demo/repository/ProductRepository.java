package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	public List<Product> findByPriceBetween(long initial_range, long final_range);
	public List<Product> findAllByOrderByPriceAsc();
}
