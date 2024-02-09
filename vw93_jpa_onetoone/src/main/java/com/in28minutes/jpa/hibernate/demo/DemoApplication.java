package com.in28minutes.jpa.hibernate.demo;



import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Query;

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
		
		Faculty f1 = new Faculty("Mohak", 2, LocalDate.now());
		fr.save(f1);
		
		Course c1 = new Course("Physics", 1000);
		c1.setCourseFaculty(f1);
		
		cr.save(c1);
		
		Course foundCourse = cr.findById(2);
		logger.info("Course details = " + foundCourse);
		
		Faculty foundFac = fr.findById(1);
		logger.info("Faculty details = " + foundFac.getFacultyCourse());		
				
	}
}
