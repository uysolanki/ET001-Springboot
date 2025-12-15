package com.enumtech.ET001FirstSpringboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enumtech.ET001FirstSpringboot.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>
{

	public List<Product> findByCategoryContaining(String a);
	
	public List<Product> findByPriceGreaterThanEqual(double a);
	
	public List<Product> findByPriceBetween(double a,double b);
	
}
