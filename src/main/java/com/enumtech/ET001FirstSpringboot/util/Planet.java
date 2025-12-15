package com.enumtech.ET001FirstSpringboot.util;

public enum Planet {
	
	MERCURY(5.0,100.0),
	VENUS(6.0,100.0),
	EARTH(7.0,100.0),
	MARS(8.0,100.0),
	JUPITER(19.0,100.0),
	SATURN(12.0,100.0),
	URANUS(10.0,100.0),
	NEPTUNE(6.0,100.0),
	PLUTO(2.0,100.0);
	
	private final double radius;
	private final double mass;
	
	private Planet(double radius, double mass) {
		this.radius = radius;
		this.mass = mass;
	}

	public double getRadius() {
		return radius;
	}

	public double getMass() {
		return mass;
	}

	
	public double calculateGravity()
	{
		return this.mass/(this.radius*this.radius);
	}
	

}
