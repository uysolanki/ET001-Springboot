package com.enumtech.ET001FirstSpringboot.service;

import java.time.LocalDate;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.enumtech.ET001FirstSpringboot.entity.User;
import com.enumtech.ET001FirstSpringboot.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;

	public void addUser(User user) {
		
		user.setAccountExpiryDate(LocalDate.now().plusYears(1));
		user.setCredentialsExpiryDate(LocalDate.now().plusMonths(3));
		user.setAccountLockedStatus(1);
		user.setEnabledStatus(1);
		user.setPassword(bcryptPasswordEncoder.encode(user.getPassword()));
		userRepository.save(user);
	}

}
