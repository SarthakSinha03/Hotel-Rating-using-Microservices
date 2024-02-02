package com.user.service.exceptions;

public class ResourceNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException() {
		super("Resource Not found");
	}
	
	public ResourceNotFoundException(String m) {
		super(m);
		System.out.println("yaha aaya hoon mai");
	}
	
}
