package com.enumtech.ET001FirstSpringboot.exception;

public class ProductNotFoundException extends RuntimeException
{
public ProductNotFoundException(String message)
{
	super(message);
}
}
