package com.user.service.exceptions;

public class ResourceNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 5265061942279470390L;
	
	
	public ResourceNotFoundException() {
		super("Resource does not exist");
	}
	
	public ResourceNotFoundException(String m) {
		super(m);
	}

}
