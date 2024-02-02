package com.rating.service.Exceptions;

public class ResourceNotFoundException extends RuntimeException{
	private static final long serialVersionUID = -9111657085513604376L;
	
	
	public ResourceNotFoundException() {
		super("Resource not found");
	}
	
	public ResourceNotFoundException(String m) {
		super(m);
	}
	

}
