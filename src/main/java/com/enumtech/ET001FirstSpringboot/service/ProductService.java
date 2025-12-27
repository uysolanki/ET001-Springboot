package com.enumtech.ET001FirstSpringboot.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.enumtech.ET001FirstSpringboot.dto.ProductRequestDTO;
import com.enumtech.ET001FirstSpringboot.dto.ProductResponseDTO;
import com.enumtech.ET001FirstSpringboot.entity.Product;
import com.enumtech.ET001FirstSpringboot.exception.ProductNotFoundException;
import com.enumtech.ET001FirstSpringboot.exception.ResourseNotFoundException;
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

	public List<Product> getProductByCategory(String category) {
		return productRepository.findByCategoryContaining(category);
	}

	public List<Product> getProductByPriceGreaterThan(double basePrice) {
		return productRepository.findByPriceGreaterThanEqual(basePrice);
	}

	public Page<Product> getProductByPagination(int pageNumber, int pageSize) {
		return productRepository.findAll(PageRequest.of(pageNumber, pageSize));
	}

	public Page<Product> getProductBySortAndPagination(String fieldName, int pageNumber, int pageSize) {
		return productRepository.findAll(PageRequest.of(pageNumber, pageSize).withSort(Sort.by(Sort.Direction.DESC,fieldName)));
	}

	public void deleteProduct(int pid) {
		if(!productRepository.existsById(pid))
		{
			throw new ProductNotFoundException("Product with ID " + pid + " does not exist in Databse");
		}
		productRepository.deleteById(pid);
		
	}

	public Product updateProduct(int pid, Product newValues) {
		if(!productRepository.existsById(pid))
		{
			throw new ProductNotFoundException("Product with ID " + pid + " does not exist in Databse");
		}
		Product productFromDB=getProduct(pid);
		productFromDB.setCategory(newValues.getCategory());
		productFromDB.setDescription(newValues.getDescription());
		productFromDB.setImage(newValues.getImage());
		productFromDB.setPrice(newValues.getPrice());
		return productRepository.save(productFromDB);
		
	}
}
