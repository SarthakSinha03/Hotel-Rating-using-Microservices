package com.user.service.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<String> handleNRFE(ResourceNotFoundException e){
		System.out.println("yaha aaya hoon");
		return ResponseEntity.noContent().build();
	}
	
	
}
