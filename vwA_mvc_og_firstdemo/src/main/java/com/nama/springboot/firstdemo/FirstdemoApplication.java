package com.nama.springboot.firstdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.nama.springboot.firstdemo.model.Employee;
import com.nama.springboot.firstdemo.model.HelloWorldBean;
import com.nama.springboot.firstdemo.model.Student;


//@SpringBootApplication = @Configuration + @ComponentScan + @AutoConfiguration
@SpringBootApplication
public class FirstdemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(FirstdemoApplication.class, args);
		
		
		Employee e = (Employee)context.getBean("emp");
		System.out.println(e.getId()+","+e.getEname());
		
		/*
        HelloWorldBean hw = (HelloWorldBean)context.getBean("hello");
		System.out.println(hw.getMessage());
		
		
		
		Student s = (Student)context.getBean("stud");
		System.out.println(s.getAge());
		System.out.println(s.getName());
		*/
		
	}

}
