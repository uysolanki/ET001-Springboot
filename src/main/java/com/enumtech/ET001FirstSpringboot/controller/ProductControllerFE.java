package com.enumtech.ET001FirstSpringboot.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.enumtech.ET001FirstSpringboot.entity.Product;
import com.enumtech.ET001FirstSpringboot.service.ProductService;

@Controller
@RequestMapping("/amazon")
public class ProductControllerFE {

	@Autowired
	ProductService productService;
	
	@RequestMapping("/all-products")
	public ModelAndView allProducts()
	{
		List<Product> products=productService.getAllProducts();
		ModelAndView mav=new ModelAndView();
		mav.setViewName("all-products");
		mav.addObject("products",products);
		return mav;
	}
	
	@RequestMapping("/add-product-form")
	public ModelAndView addProductForm()
	{
		Product p1=new Product();	
		ModelAndView mav=new ModelAndView();
		mav.setViewName("add-product-form");
		mav.addObject("product",p1);
		return mav;
	}
	
	@PostMapping("/add-product")
	public String addProduct(@ModelAttribute Product product, @RequestParam("imageFile") MultipartFile file) throws IOException
	{
		if (!file.isEmpty()) {

	        String uploadDir = "uploads/";
	        Files.createDirectories(Paths.get(uploadDir));

	        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
	        Path filePath = Paths.get(uploadDir, fileName);

	        Files.write(filePath, file.getBytes());

	        // Save only filename or relative path
	        product.setImage("http://localhost:8089/uploads/" + fileName);
	    }

		
		productService.addProduct(product);
		return "redirect:/amazon/all-products";
	}
	
	@RequestMapping("/delete-product/{pid}")
	public String deleteProduct(@PathVariable int pid)		
	{
		productService.deleteProduct(pid);
		return "redirect:/amazon/all-products";
	}
	
	@RequestMapping("/update-product-form/{pid}")
	public ModelAndView updateProductForm(@PathVariable int pid)
	{	
		ModelAndView mav=new ModelAndView();
		Product p1=productService.getProduct(pid);
		mav.setViewName("update-product-form");
		mav.addObject("product",p1);
		return mav;
	}
	
	@PostMapping("/update-product/{prodId}")
	public String updateProduct(@PathVariable int prodId, @ModelAttribute Product newValues)		
	{
		Product product=productService.updateProduct(prodId,newValues);
		return "redirect:/amazon/all-products";
	}
}

