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
import org.springframework.context.ConfigurableApplicationContext;

import com.in28minutes.jpa.hibernate.demo.entity.Course;
import com.in28minutes.jpa.hibernate.demo.entity.Faculty;
import com.in28minutes.jpa.hibernate.demo.repository.CourseRepo;
import com.in28minutes.jpa.hibernate.demo.repository.FacultyRepo;




@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	
	@Autowired
	private CourseRepo cr;
	
	@Autowired
	private FacultyRepo fr;

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);
//		System.out.println(ctx.containsBean("course"));
//		System.out.println(ctx.containsBean("faculty"));
//		System.out.print("Hi");
	}
	
	@Override
	public void run(String... arg0) throws Exception {
		
		
	//	============================================================================================
		Course c1 = new Course("Java", 1000);  
		cr.saveCourse(c1);  
		//intentionally saving course without a faculty
		//this works as Faculty courseFaculty is not a "required" field in the table
		
		
		
		Faculty f1 = new Faculty("Mohak", 2, LocalDate.now());  //POJO
		fr.saveFaculty(f1);
		
		
		//====================================================================================================
		//this returned obj is not a tracked object, as it is not a part of any transaction
		Course foundCourse = cr.findCourseById(1); 
		foundCourse.setCoursePrice(100000000); //this won't be reflected in DB
		foundCourse = cr.findCourseById(1);
		System.out.println("Course with id = 1 ==> " + foundCourse + "\n");
		
		
    	cr.updateCoursePrice(1, 1300);
		cr.updateCourseFaculty(1, f1);
		
		
	    foundCourse = cr.findCourseById(1);
	    System.out.println("Course with id = 1 (After update) ==> " + foundCourse + "\n");
	    
	    //=====================================================================================================
	    
	    Faculty f2 = new Faculty("Achin", 10, LocalDate.now());
	    Course c2 = new Course("DSA", 4000);
	    c2.setCourseFaculty(f2); //setting in POJO
	    fr.saveFaculty(f2);  //first save faculty then only save course
	    cr.saveCourse(c2);
	    
	    
	    foundCourse = cr.findCourseById(4);
	    System.out.println("Course with id = 4  ==> " + foundCourse + "\n");
	    System.out.println("Course " + foundCourse.getCourseName() + " is taught by " 
	    + foundCourse.getCourseFaculty().getFacultyName() + " with experience of " 
	    + foundCourse.getCourseFaculty().getExperience() + " years ");
	    
	    
	    //====================================================================================================
	    
	    
	    f2.setExperience(15);  //this won't set the experience in db
	    fr.updateFacultyExperience(3, 15);  //this will
	    
	    System.out.println("Faculty f-3 => " + fr.findFacultyById(3));
	    
	    //Course c2 will also have updated faculty
	    //using the same object as earlier won't work :((((, foundCourse is not synced and has a stale entry
	    System.out.println("(BEFORE) Course " + foundCourse.getCourseName() + " is taught by " 
	    	    + foundCourse.getCourseFaculty().getFacultyName() + " with experience of " 
	    	    + foundCourse.getCourseFaculty().getExperience() + " years ");
	    
	    foundCourse = cr.findCourseById(4);
	    
	    //this works as we fetched again and will have a fresh/update entry for faculty
	    System.out.println("(AFTER) Course " + foundCourse.getCourseName() + " is taught by " 
	    	    + foundCourse.getCourseFaculty().getFacultyName() + " with experience of " 
	    	    + foundCourse.getCourseFaculty().getExperience() + " years ");
	    
	    //=========================================================================================================

				
	}
}
