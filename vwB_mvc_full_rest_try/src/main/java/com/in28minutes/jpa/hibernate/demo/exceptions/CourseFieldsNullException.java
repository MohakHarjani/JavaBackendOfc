package com.in28minutes.jpa.hibernate.demo.exceptions;

public class CourseFieldsNullException extends RuntimeException{
	
	private String msg;
	
	public CourseFieldsNullException(String msg)
	{
		this.msg = msg;
	}
	
	@Override
	public String getMessage()
	{
		return this.msg;
	}

}
