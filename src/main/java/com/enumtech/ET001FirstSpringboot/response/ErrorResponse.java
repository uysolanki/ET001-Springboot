package com.enumtech.ET001FirstSpringboot.response;

import org.springframework.http.HttpStatusCode;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ErrorResponse {

	private String errorMessage;
	private int httpStatusCode;
	private boolean success;
}
