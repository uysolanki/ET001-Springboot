package com.enumtech.ET001FirstSpringboot.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enumtech.ET001FirstSpringboot.dto.ProductRequestDTO;
import com.enumtech.ET001FirstSpringboot.dto.ProductResponseDTO;
import com.enumtech.ET001FirstSpringboot.entity.Product;
import com.enumtech.ET001FirstSpringboot.exception.ProductNotFoundException;
import com.enumtech.ET001FirstSpringboot.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;
	@Autowired
	ModelMapper modelMapper;

	public Product addProduct(Product product) {
		return productRepository.save(product);
		
	}

	public List<Product> addMultipleProductByRequestBody(List<Product> products) {
		return productRepository.saveAll(products);
	}

	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	public Product getProduct(int pid) {
		Optional<Product> product=productRepository.findById(pid);
		Product prod=null;
		try
		{
			prod=product.get();
		}
		catch(NoSuchElementException e1)
		{
			System.out.println("WARN ---" +e1.getMessage());
			throw new ProductNotFoundException("Product does not exist in Databse");
		}
		return prod;
	}

	public ProductResponseDTO addProduct(ProductRequestDTO productReqDTO) {
        Product product = modelMapper.map(productReqDTO, Product.class);
        Product savedProduct=productRepository.save(product);
        return modelMapper.map(savedProduct, ProductResponseDTO.class);
        
	}
}
