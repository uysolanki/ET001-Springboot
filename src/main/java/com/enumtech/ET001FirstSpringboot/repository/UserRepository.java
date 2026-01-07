package com.enumtech.ET001FirstSpringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enumtech.ET001FirstSpringboot.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	public User findByUsername(String str);
}
