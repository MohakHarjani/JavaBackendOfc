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

		//BI-DIRECTIONAL ONE-TO-ONE MAPPING
		//We can fetch Faculty from Course
		//We can also fetch Course from a Faculty
		
		//=============================================================================================
		//NOT GOOD, BUT WORKING ....   :|
		//Not using mappedBy on non-owning entity won't cause problem in OneToOne...
		//But it is actually redundant, and un-professional
		
//		Course c1 = new Course("Maths", 1000);
//		Faculty f1 = new Faculty("Mohak", 2, LocalDate.now());
//		cr.saveCourse(c1);
//		fr.saveFaculty(f1);
//		
//		cr.updateCourseFaculty(1, f1);
//		fr.updateFacultyCourse(2, c1);

		//=================================================================================================
		//Method-1 of creating and saving
		Faculty f1 = new Faculty("Mohak", 10, LocalDate.now());
		fr.saveFaculty(f1);
		
		Course c1 = new Course("Maths", 1000);
		c1.setCourseFaculty(f1);
		cr.saveCourse(c1);
		//-------------------------------------------------------------
		
		//Method-2 of creating and saving
		Faculty f2 = new Faculty("Harsh", 19, LocalDate.now());
		Course c2 = new Course("Science", 3000);
		c2.setCourseFaculty(f2); //Yes it would work :), 
		//I can push a POJO in course, but I have to save faculty before Course
		fr.saveFaculty(f2);
		cr.saveCourse(c2);
		//-----------------------------------------------------------
		Faculty f3 = new Faculty("Vishwas", 12, LocalDate.now());
		fr.saveFaculty(f3);
		
		Course c3 = new Course("Sports", 8000);
		c3.setCourseFaculty(f3);
		cr.saveCourse(c3);
		
		//===============================================================================================
		
		Course foundCourse = cr.findCourseById(2);
		System.out.println("Course " + foundCourse.getCourseName() + " => " + foundCourse);
		Faculty foundCourseFaculty = foundCourse.getCourseFaculty();
		System.out.println("Faculty of course " + foundCourse.getCourseName() + "=>" + foundCourseFaculty + "\n");
		
		//====================================================================================================
		
		//I setted faculty for a course
		//But not course for a faculty......
		//I can get still get the course details of a paticular faculty
		
		
		Faculty foundFaculty = fr.findFacultyById(5);  //when "finding" using EM, it will populate the course field
		System.out.println("Faculty " + foundFaculty.getFacultyName() + " => " + foundFaculty);
		Course foundFacultyCourse = foundFaculty.getFacultyCourse();
		System.out.println("Course of faculty " + foundFaculty.getFacultyName() + "=>" + foundFacultyCourse + "\n");

		
		//==================================================================================================================================
		//any changes done on course will be reflected in faculty
		foundFaculty = fr.findFacultyById(3);
		System.out.println("Faculty's Course (BEFORE UPDATE ON COURSE) => " + foundFaculty.getFacultyCourse());
		
		cr.updateCoursePrice(4, 5500);
		
		foundFaculty = fr.findFacultyById(3);
		System.out.println("Faculty's Course (AFTER UPDATE ON COURSE) => " + foundFaculty.getFacultyCourse());
		
		//===============================================================================================================================
	
	}
}
