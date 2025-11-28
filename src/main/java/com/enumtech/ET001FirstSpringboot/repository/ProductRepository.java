package com.enumtech.ET001FirstSpringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enumtech.ET001FirstSpringboot.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>
{

}
