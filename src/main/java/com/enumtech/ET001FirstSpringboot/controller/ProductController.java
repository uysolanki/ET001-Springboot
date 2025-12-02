package com.enumtech.ET001FirstSpringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.enumtech.ET001FirstSpringboot.entity.Product;
import com.enumtech.ET001FirstSpringboot.exception.ProductNotFoundException;
import com.enumtech.ET001FirstSpringboot.response.ErrorResponse;
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
		
		System.out.println("TO Full Stack Deve");
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
	
	@PostMapping("/addMultipleProductByRequestBody")
	public List<Product> addMultipleProductByRequestBody(@RequestBody List<Product> products)		
	{
		return productService.addMultipleProductByRequestBody(products);
	}
	
	@GetMapping("/getAllProducts")
	public ResponseEntity<List<Product>> getAllProducts()		
	{
		List<Product> allProd=productService.getAllProducts();
		return new ResponseEntity<List<Product>>(allProd,HttpStatus.OK);
	}
	
	@GetMapping("/getProduct/{pid}")
	public ResponseEntity<?> getProduct(@PathVariable int pid)		
	{
		Product product=null;
		try
		{
			product=productService.getProduct(pid);
		}
		catch(ProductNotFoundException ex1)
		{
			return new ResponseEntity<ErrorResponse> (new ErrorResponse(ex1.getMessage(),HttpStatus.BAD_REQUEST.value(),false),HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<Product>(product,HttpStatus.OK);
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
