package com.in28minutes.jpa.hibernate.demo.exception;

public class EmpNotFoundException extends RuntimeException{
	private String message;
	
	
	public EmpNotFoundException(String message)
	{
		this.message = message;
	}
	
	@Override
	public String getMessage()
	{
		return this.message;
	}
}
