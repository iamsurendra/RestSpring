package com.cg.jpacrud.Exception;

public class AuthorException extends Exception {
	
	String message;

	public AuthorException(String message) {

		this.message = message;
	}

	@Override
	public String getMessage() {
		return this.message;
	}

}
