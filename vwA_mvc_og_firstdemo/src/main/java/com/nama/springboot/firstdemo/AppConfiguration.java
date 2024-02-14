package com.nama.springboot.firstdemo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("student")
public class AppConfiguration {
	
	private int rollno;
	private String name;
	private double age;
	
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getAge() {
		return age;
	}
	public void setAge(double age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "AppConfiguration [rollno=" + rollno + ", name=" + name + ", age=" + age + "]";
	}
	
	

}
