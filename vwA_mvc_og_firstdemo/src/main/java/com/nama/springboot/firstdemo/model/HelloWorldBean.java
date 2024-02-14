package com.nama.springboot.firstdemo.model;

public class HelloWorldBean {
	
	private String message;
	private int nousers;
	
	public HelloWorldBean(String message,int totusers)
	{
		this.message =  message;
		this.nousers = totusers;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getNousers() {
		return nousers;
	}

	public void setNousers(int nousers) {
		this.nousers = nousers;
	}
	
	
	
	

}

