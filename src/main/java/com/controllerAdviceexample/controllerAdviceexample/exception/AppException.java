package com.controllerAdviceexample.controllerAdviceexample.exception;

public class AppException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AppException(String message ,Long id) {
        super( message + id);
    }
	
	public AppException(String message) {
        super( message);
    }
	
}
