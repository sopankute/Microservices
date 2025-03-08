package com.userservice.exception;

public class ResourceNotFoundException extends RuntimeException{

	public ResourceNotFoundException() {
		super("Resource Not Found on Server");
	}
	
	public ResourceNotFoundException(String msg) {
		super(msg);
	} 
	
}
