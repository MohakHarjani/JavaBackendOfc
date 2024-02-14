package com.nama.springboot.firstdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import com.nama.springboot.firstdemo.model.Employee;
import com.nama.springboot.firstdemo.model.HelloWorldBean;

//@PropertySource("classpath:application.properties")
@Configuration
@Profile("dev")
class MySpringConfigurationDev {
	
  
	@Value("${welcome.message}")
	String message;
	
  @Bean(name="hello")
  public HelloWorldBean greetme() {
    return new HelloWorldBean(message,5);
  }
  
  

  
 
}