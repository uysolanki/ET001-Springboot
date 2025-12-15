package com.enumtech.ET001FirstSpringboot.exception;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.enumtech.ET001FirstSpringboot.response.APIError;
import com.enumtech.ET001FirstSpringboot.response.ErrorResponse;
import com.enumtech.ET001FirstSpringboot.util.Category;

//@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<ErrorResponse> handlePlayerNotFound(ProductNotFoundException ex)
	{ 
		return new ResponseEntity<ErrorResponse> (new ErrorResponse(ex.getMessage(),HttpStatus.BAD_REQUEST.value(),false),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<List<APIError>> handleValidationExceptions(MethodArgumentNotValidException ex) {

		List<APIError> errors = new ArrayList<>();
				for (FieldError error : ex.getBindingResult().getFieldErrors()) 
				{
					APIError apiError = new APIError(error.getDefaultMessage(), error.getField(), error.getRejectedValue());
			        errors.add(apiError);
			    }
		 return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> handleEnumErrors(HttpMessageNotReadableException ex) {
		
		
		Throwable cause=ex.getCause();
		Object rejected = null;
		String fieldName=null;
		String allowedValues=null;
	    // Check if Jackson threw InvalidFormatException
	    if (cause instanceof com.fasterxml.jackson.databind.exc.InvalidFormatException invalidFormatEx) {
	        rejected = invalidFormatEx.getValue();   // the wrong value user passed
	    
	    
	    if (!invalidFormatEx.getPath().isEmpty()) {
            fieldName = invalidFormatEx.getPath().get(0).getFieldName();
        }
	    
        String message = ex.getCause() != null ? ex.getCause().getMessage() : ex.getMessage();

        // Extract enum values from your Category enum
        allowedValues = Arrays.stream(Category.values())
                                     .map(Enum::name)
                                     .collect(Collectors.joining(", "));
	    }
        APIError error = new APIError(
                "Invalid category. Allowed values: " + allowedValues,
                fieldName,
                rejected
        );
	    
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
	
}
