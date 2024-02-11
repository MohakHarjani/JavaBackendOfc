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
		//MANY COURSES MAP TO ONE FACULTY (OWNING SIDE)
		
		//======================================================================================================
		//(make course, add course list inside faculty)
		//THIS WON'T WORKKKKKK :( :(
		//FIRST WE HAVE TO POPULATE FACULTY (NON-OWNING)
		//THEN POPULATE COURSE (OWNING)
		
//		Course c1 = new Course("Accounts", 1000);	 cr.saveCourse(c1);   
//		Course c2 = new Course("BST", 3000);	 cr.saveCourse(c2);  
//		Course c3 = new Course("ECO", 2000);	 cr.saveCourse(c3); 
//		
//		
//		Faculty f1 = new Faculty("Mohak", 2, LocalDate.now(), Arrays.asList(c1)); fr.saveFaculty(f1);  
//		Faculty f2 = new Faculty("Manav", 5, LocalDate.now(), Arrays.asList(c2, c3)); fr.saveFaculty(f2); 
		
		//====================================================================================================
		
		Faculty f1 = new Faculty("Mohak", 2, LocalDate.now());  fr.saveFaculty(f1);  //id-1
		Course c1 = new Course("Accounts", 1000);   c1.setCourseFaulty(f1);   cr.saveCourse(c1); //id-2
		
		Faculty f2 = new Faculty("Manav", 5, LocalDate.now()); fr.saveFaculty(f2);   //id-3
		Course c2 = new Course("BST", 3000); c2.setCourseFaulty(f2); cr.saveCourse(c2);  //id-4
		Course c3 = new Course("ECO", 2000); c3.setCourseFaulty(f2); cr.saveCourse(c3);  //id-5
		
		
		Faculty f3 = new Faculty("Tushar", 6, LocalDate.now()); fr.saveFaculty(f3);  //id-6
		
		Course c4 = new Course("IP", 1000);  //id-7
		c4.setCourseFaulty(f3);
		cr.saveCourse(c4);  
		
		Course c5 = new Course("PHYSICAL ED.", 9000);   //id-8
		c5.setCourseFaulty(f3);
		cr.saveCourse(c5);  
		
		Course c6 = new Course("CS", 4000);    //id-9
		c6.setCourseFaulty(f3);
		cr.saveCourse(c6); 
		
		//======================================================================================================
		//Fetching faculty of a given course
		
		//THIS WORKS.....BECAUSE FETCH TYPE OF "MANY_TO_ONE" IS EAGER......
		//THE COMPLETE OBJECT IS FETCHED WHEN WE CALL "FIND" USING ENTITY MANAGER 
		Course foundCourse = cr.findCourseById(7);
		System.out.println("Complete course (along with faculty details) => " + foundCourse + "\n");
		
		
	    Faculty foundCourseFaculty = cr.getCourseFaculty(7);		
	    System.out.println("Faculty of course-7 => " + foundCourseFaculty + "\n");
		
		//====================================================================================================
		
		
		//Fetching the courseList of a given faculty.....
		
		///directly fetching list from POJO won't work...you have to fetch in a transaction
		//f2.getFacultyCourseList(); 
		
		List<Course>foundCourseList  = fr.getCourseList(6);
    	System.out.println("CourseList of faculty with id-6 => ");
    	foundCourseList.forEach((Course c)->System.out.println(c));
    	System.out.println("\n");
    	
    	//=========================================================================================================	
	
	}
}
