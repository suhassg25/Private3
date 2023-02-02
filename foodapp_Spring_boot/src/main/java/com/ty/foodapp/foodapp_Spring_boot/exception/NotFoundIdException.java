package com.ty.foodapp.foodapp_Spring_boot.exception;

public class NotFoundIdException extends RuntimeException {

	String message="Data having this ID not found in the Data Base";
	@Override
	public String getMessage() {
		return message;
	}
	public NotFoundIdException(String message) {
		super();
		this.message = message;
	}
	public NotFoundIdException() {
		super();
			}

	
	
}
