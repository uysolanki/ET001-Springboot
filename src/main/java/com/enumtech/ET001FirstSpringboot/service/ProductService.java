package com.enumtech.ET001FirstSpringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enumtech.ET001FirstSpringboot.entity.Product;
import com.enumtech.ET001FirstSpringboot.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;

	public Product addProduct(Product product) {
		return productRepository.save(product);
		
	}
}
