package com.in28minutes.jpa.hibernate.demo;



import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
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
		SpringApplication.run(DemoApplication.class, args);

	}
	
	@Override
	public void run(String... arg0) throws Exception {

		
		//ONE FACULTY MAPS TO MANY COURSES
		//Same course can be added to many faculties
		
		Course c1 = new Course("Accounts", 1000);	 cr.saveCourse(c1);  //id-1
		Course c2 = new Course("BST", 3000);	 cr.saveCourse(c2); //id-2
		Course c3 = new Course("ECO", 2000);	 cr.saveCourse(c3); //id-3
		Course c4 = new Course("IP", 1000);    cr.saveCourse(c4);  //id-4
		Course c5 = new Course("PHYSICAL ED.", 9000);    cr.saveCourse(c5);  //id-5
		Course c6 = new Course("CS", 4000);    cr.saveCourse(c6);   //id-6
		
		//=====================================================================================
		//id=7
		Faculty f1 = new Faculty("Mohak", 2, LocalDate.now(), Arrays.asList(c1, c2)); fr.saveFaculty(f1);  
		
		//id-8
		Faculty f2 = new Faculty("Manav", 5, LocalDate.now(), Arrays.asList(c2, c3, c4)); fr.saveFaculty(f2);  
		
		//id-9
    	Faculty f3 = new Faculty("Tushar", 6, LocalDate.now(), Arrays.asList(c3, c5, c6));  fr.saveFaculty(f3);

		
//		//====================================================================================================
	
		//Fetching the courseList of a given faculty.....
	
		///directly fetching list from POJO won't work...you have to fetch in a transaction
		//f3.getFacultyCourseList(); 
		
		
		List<Course>foundCourseList  = fr.getCourseList(9);
    	System.out.println("CourseList of faculty with id-9 (BEFORE) => ");
    	foundCourseList.forEach((Course c)->System.out.println(c));
    	System.out.println("\n");
		
    	
		cr.updateCoursePrice(3, 7000);
		
		foundCourseList  = fr.getCourseList(9);
    	System.out.println("CourseList of faculty with id-9 (AFTER) => ");
    	foundCourseList.forEach((Course c)->System.out.println(c));
    	System.out.println("\n");
    	
    	foundCourseList  = fr.getCourseList(8);
    	System.out.println("CourseList of faculty with id-8  => ");
    	foundCourseList.forEach((Course c)->System.out.println(c));
    	System.out.println("\n");
  	
//    	//=====================================================================================================
	

	
	}
}
