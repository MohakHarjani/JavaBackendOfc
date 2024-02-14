package com.nama.springboot.firstdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import com.nama.springboot.firstdemo.model.Employee;
import com.nama.springboot.firstdemo.model.Student;

//@PropertySource("classpath:application.properties")
@Configuration
@Profile("prod")
class MySpringConfigurationProd {
	
	@Autowired
	AppConfiguration appprop;
	/*
	@Value("${student.rollno}")
	int rollno;
	
	
	@Value("${student.name}")
	String name;
	
	@Value("${student.age}")
	double age;
   */

  
  @Bean(name="stud")
  public Student mystud() {
  //  return new Student(rollno,name,age);
	  
	  return new Student(appprop.getRollno(),appprop.getName(),appprop.getAge());
  }
  
  

  
 
}