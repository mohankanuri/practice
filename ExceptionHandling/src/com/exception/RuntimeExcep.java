package com.exception;

public class RuntimeExcep extends java.lang.RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String message;

    // Overrides Exception's getMessage()
    @Override
    public String getMessage(){
    	String message = "Array size should not be more than 5";
        return message;
    }

    // Testing
    
    }

