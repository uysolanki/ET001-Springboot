package com.enumtech.ET001FirstSpringboot.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class Rating {
	 public double rate;
	 public int count;
}
