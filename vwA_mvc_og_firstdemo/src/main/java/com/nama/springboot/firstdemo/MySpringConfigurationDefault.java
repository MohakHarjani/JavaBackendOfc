package com.nama.springboot.firstdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import com.nama.springboot.firstdemo.model.Employee;

@PropertySource("classpath:application.properties")
@Configuration
class MySpringConfiguration {
	
	@Value("${id}")
	int id;
	
	
	@Value("${name}")
	String name;


  
  @Bean(name="emp")
  public Employee myemp() {
    return new Employee(id,name);
  }
  
  

  
 
}