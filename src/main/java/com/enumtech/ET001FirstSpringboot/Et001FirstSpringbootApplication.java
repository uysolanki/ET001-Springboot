package com.enumtech.ET001FirstSpringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.enumtech.ET001FirstSpringboot.util.Direction;
import com.enumtech.ET001FirstSpringboot.util.Planet;

@SpringBootApplication
public class Et001FirstSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(Et001FirstSpringbootApplication.class, args);
		
		Direction dir;
		
		dir=Direction.EAST;
		dir=Direction.NORTHEAST;
		
		System.out.println("I want to go in "+ dir + "Direction");
		
		Planet planet;
		planet=Planet.EARTH;
		
		System.out.println(planet.calculateGravity());
		
	}

}
