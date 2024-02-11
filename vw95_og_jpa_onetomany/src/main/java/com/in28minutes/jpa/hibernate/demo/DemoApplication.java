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
		
		Course c = new Course("Core Java",15000);
		cr.save(c);
		

		Course c1 = new Course("SpringBoot",25000);
		cr.save(c1);
		
		List<Course> lst = Arrays.asList(c,c1);
		
		//String facultyName, int totExp, LocalDate joinDate
		Faculty f = new Faculty("Nisha Tyagi",15,LocalDate.now(),lst);
		fr.save(f);
		
		//retrieve the faculty with facultyId : 3
		f = fr.findById(3);
		//retrieve all courses taught by that faculty with facultyId: 3
		List<Course> lst1 =  fr.getAllCourses(f.getFacultyId());
		System.out.println("courses taught by faculty:"+f.getFacultyName()+" are:");
		lst1.forEach(System.out::println);
		
	}
}
