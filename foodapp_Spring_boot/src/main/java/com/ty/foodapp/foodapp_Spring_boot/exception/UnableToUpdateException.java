package com.ty.foodapp.foodapp_Spring_boot.exception;

public class UnableToUpdateException extends RuntimeException {

	String message="Unable update for Id which does not Exist";

	@Override
	public String getMessage() {
	
		return message;
	}

	public UnableToUpdateException() {
		super();
		
	}
	
	
	
}
