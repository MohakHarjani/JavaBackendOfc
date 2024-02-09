package com.in28minutes.jpa.hibernate.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.in28minutes.jpa.hibernate.demo.entity.Course;
import com.in28minutes.jpa.hibernate.demo.entity.Faculty;
import com.in28minutes.jpa.hibernate.demo.repository.CourseRepo;
import com.in28minutes.jpa.hibernate.demo.repository.FacultyRepo;

import java.time.LocalDate;
import java.util.*;


@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CourseRepo cr;
	
	@Autowired
	FacultyRepo fr;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		
		
		
		//String facultyName, int totExp, LocalDate joinDate
		Faculty f = new Faculty(1,"Nisha Tyagi",15,LocalDate.now());
		fr.save(f);
		
		Course c = new Course(101,"Core Java",15000);
		c.setCourseFaculty(f);
		cr.save(c);
		
		c = cr.findById(101);
		System.out.println("course:"+c.getCourseName()+" has faculty:"+c.getCourseFaculty());
		
		/*
		cr.updateCourseName(c.getCourseId(),"JPA");
	    c= cr.findById(1);
		System.out.println(c);
		
		List<Course> lst = cr.retrieveEmployees();
		System.out.println(lst);
		
		*/
		
		f = fr.findById(1);
		System.out.println("faculty:"+f.getFacultyName()+" teaches course:"+f.getCourse());
		
		
		
	}
}
