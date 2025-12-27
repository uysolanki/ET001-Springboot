package com.enumtech.ET001FirstSpringboot.exception;

public class ResourseNotFoundException extends RuntimeException
{
public ResourseNotFoundException(String message)
{
	super(message);
}
}
