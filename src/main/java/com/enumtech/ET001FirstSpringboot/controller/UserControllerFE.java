package com.enumtech.ET001FirstSpringboot.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.enumtech.ET001FirstSpringboot.entity.Product;
import com.enumtech.ET001FirstSpringboot.entity.User;
import com.enumtech.ET001FirstSpringboot.service.UserService;

@Controller
@RequestMapping("/amazon")
public class UserControllerFE {
	
	@Autowired
	UserService userService;
	
	
	@RequestMapping("/add-user-form")
	public ModelAndView addProductForm()
	{
		User u1=new User();	
		ModelAndView mav=new ModelAndView();
		mav.setViewName("add-user-form");
		mav.addObject("user",u1);
		return mav;
	}
	
	@PostMapping("/add-user")
	public String addProduct(@ModelAttribute User user) 
	{		
		userService.addUser(user);
		return "redirect:/amazon/all-products";
	}


}
