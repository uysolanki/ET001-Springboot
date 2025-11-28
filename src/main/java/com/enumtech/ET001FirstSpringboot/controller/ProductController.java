package com.enumtech.ET001FirstSpringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.enumtech.ET001FirstSpringboot.entity.Product;
import com.enumtech.ET001FirstSpringboot.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	ProductService productService;
	
	@RequestMapping("/hello")
	public Product addProduct()
	{
		Product product=Product.builder()
				.title("Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops")
				.description("Your perfect pack for everyday use and walks in the forest")
				.price(109.95)
				.category("men's clothing")
				.image("https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_t.png")
				.build();
		return productService.addProduct(product);
		//return "test";
	}
	
	@PostMapping("/addProductByRequestParam")
	public Product addProductByRequestParam(
			@RequestParam("a") String title,
			@RequestParam("b") String description,
			@RequestParam("c") double price,
			@RequestParam("d") String category,
			@RequestParam("e") String image			
			)
	{
		Product product=Product.builder()
				.title(title)
				.description(description)
				.price(price)
				.category(category)
				.image(image)
				.build();
		return productService.addProduct(product);
		//return "test";
	}
	
	@PostMapping("/addProductByRequestParam1")
	public Product addProductByRequestParam1(
			@RequestParam String title,
			@RequestParam String description,
			@RequestParam double price,
			@RequestParam String category,
			@RequestParam String image			
			)
	{
		Product product=Product.builder()
				.title(title)
				.description(description)
				.price(price)
				.category(category)
				.image(image)
				.build();
		return productService.addProduct(product);
		//return "test";
	}
	
	
	@PostMapping("/addProductByPathVariable/{a}/{b}/{c}/{d}/{e}")
	public Product addProductByPathVariable(
			@PathVariable("a") String title,
			@PathVariable("b") String description,
			@PathVariable("c") double price,
			@PathVariable("d") String category,
			@PathVariable("e") String image			
			)
	{
		Product product=Product.builder()
				.title(title)
				.description(description)
				.price(price)
				.category(category)
				.image(image)
				.build();
		return productService.addProduct(product);
		//return "test";
	}
	
	@PostMapping("/addProductByPathVariable1/{title}/{description}/{price}/{category}/{image}")
	public Product addProductByPathVariable1(
			@PathVariable String title,
			@PathVariable String description,
			@PathVariable double price,
			@PathVariable String category,
			@PathVariable String image			
			)
	{
		Product product=Product.builder()
				.title(title)
				.description(description)
				.price(price)
				.category(category)
				.image(image)
				.build();
		return productService.addProduct(product);
		//return "test";
	}
	
	@PostMapping("/addProductByRequestBody")
	public Product addProductByRequestBody(@RequestBody Product product)		
	{
		return productService.addProduct(product);
	}
}

/*
  {
    "id": 10,
    "title": "trouser",
    "price": 199.9,
    "description": "made from cotton",
    "category": "Garments",
    "image": "test image",
    "rating": null
}
*/
