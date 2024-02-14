package com.nama.springboot.firstdemo.model;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class Student {
	
    @Value("${student.rollno}") int rollno;
    @Value("${student.name}") String name;
    @Value("${student.age}")double age;
	
	
    public Student()
    {
    	
    }
    
	public Student(int rollno, String name, double age) {
		super();
		this.rollno = rollno;
		this.name = name;
		this.age = age;
	}
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

	
	

}
