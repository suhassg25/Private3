package com.ty.foodapp.foodapp_Spring_boot.exception;

public class UnbaleToDeleteException extends RuntimeException {
	
	
	String message="Can not be deleted Id Which is not present";
	
	
	@Override
	public String getMessage()
	{
		return message;
	}


	public UnbaleToDeleteException() {
		super();
		
	}
	
	
	
}
