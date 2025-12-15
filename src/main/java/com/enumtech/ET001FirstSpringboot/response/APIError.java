package com.enumtech.ET001FirstSpringboot.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class APIError {
	    private String message;   		//Title must be between 3 and 100 characters
	    private String field;     		//Title
	    private Object rejectedValue;	//Ac
}


/*

[]


[
{
" message":"Title must be between 3 and 100 characters"
"field":"Title"
"rejectedValue" : "Ac"
},
{
"message":""Price must be greater than 0"
"field":"Price"
"rejectedValue" : "-1"
}
]

*/