package com.insurance.exception;

public class IdNotFoundException extends RuntimeException {

	private String message;

	public IdNotFoundException(String message) {
		super(message);
		//this.message = message;
	}



}
