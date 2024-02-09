package com.in28minutes.jpa.hibernate.demo;



import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.in28minutes.jpa.hibernate.demo.entity.Course;
import com.in28minutes.jpa.hibernate.demo.entity.Faculty;
import com.in28minutes.jpa.hibernate.demo.repository.CourseDataJpaRepository;
import com.in28minutes.jpa.hibernate.demo.repository.CourseRepo;
import com.in28minutes.jpa.hibernate.demo.repository.FacultyRepo;



@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CourseDataJpaRepository cr;
	
	@Autowired
	FacultyRepo fr;
	

	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Override
	public void run(String... arg0) throws Exception {
		

		Faculty f1 = new Faculty("Mohak", 2, LocalDate.now());   fr.save(f1);
		Faculty f2 = new Faculty("Virat", 5, LocalDate.now());    fr.save(f2);
		Faculty f3 = new Faculty("Rohit", 6, LocalDate.now());   fr.save(f3);
		Faculty f4 = new Faculty("Sachin", 10, LocalDate.now());  fr.save(f4);
		
		
		Course c1 = new Course("Physics", 1000);
		c1.setCourseFaculty(f1);
		cr.save(c1);
		
		Course c2 = new Course("Batting", 3000);
		c2.setCourseFaculty(f2);
		cr.save(c2);
		
		
		Course c3 = new Course("Bowling", 2000);	
		c3.setCourseFaculty(f3);
		cr.save(c3);
		
		
		Course c4 = new Course("Fielding", 1000);   
		c4.setCourseFaculty(f4);
		cr.save(c4);
		
		
		System.out.println("Total Course count => " + cr.count());
		
		
	     Course battingCourse = cr.findByCourseName("Batting");
	     System.out.println("Batting course => " + battingCourse);
	     
	     Course faculty4Course = cr.findByCourseFaculty(f4);
	     System.out.println("Faculty - 4 " + f4.getFacultyName() + "'s  course => " + faculty4Course);
		
	

	     List<Course>allCourses = cr.findAll();
	     allCourses.stream().forEach((Course c)->System.out.println(c));
	     System.out.println("\n");
	
	     
	 	Sort sort = Sort.by(Sort.Direction.ASC, "courseName");
	 	List<Course>sortedCourses = cr.findAll(sort);
	 	sortedCourses.stream().forEach((Course c)->System.out.println(c));
	 	System.out.println("\n");
	 	
	 	Optional<Course>foundCourse = cr.findById(5);
	 	if (foundCourse.isPresent())
	 	    System.out.println("Found Course = " + foundCourse.get());
	 	else
	 		System.out.println("Course withd id = 5 not found");

	 	cr.deleteById(5);
	 	
		foundCourse = cr.findById(5);
	 	if (foundCourse.isPresent())
	 	    System.out.println("Found Course = " + foundCourse.get());
	 	else
	 		System.out.println("Course withd id = 5 not found");
	 	
	 	
	 	
	 	List<Course> list = cr.deleteByCourseName("Batting");
	 	System.out.println("Deleted => " + list);
	 	
		List<Course>patternList = cr.courseWithPatternInName();
		System.out.println("Courses with pattern %ld% " + patternList);
		
		patternList = cr.courseWithPatternInNameBySQL();
		System.out.println("Courses with pattern (SQL) %ld% " + patternList);
		
		
		
	    Faculty f5 = new Faculty("Rahul", 10, LocalDate.now());  
	    fr.save(f5);
		Course c5 = new Course("Fielding", 1000);  //multiple courses but different Id
		c5.setCourseFaculty(f5);
		cr.save(c5);
		
		long count = cr.countByCourseName("Fielding");
		System.out.println("Count of Fielding courses =>" + count);
		
		List<Course>fieldingCourses = cr.findByCourseNameOrderByCourseIdDesc("Fielding");
		System.out.print("Fielding courses => ");
		fieldingCourses.stream().forEach(System.out :: println);
		
		//each page has a size = 2, 
		//from total/2 pages, get the 1st index page
		
		PageRequest pr = PageRequest.of(1, 2, sort);	
		Page<Course>coursePage = cr.findAll(pr);	

	
		System.out.println(coursePage.getTotalElements());
		System.out.println(coursePage.getTotalPages());
		
		int totalPages = coursePage.getTotalPages();
		//int totalCount = coursePage.getTotalElements();
		
		for (int pageIdx = 0; pageIdx < totalPages; pageIdx++)
		{
			PageRequest prr = PageRequest.of(pageIdx, 2, sort);
			Page<Course>cp = cr.findAll(prr);
			cp.forEach(System.out :: println);
			System.out.println(".....");
			
			System.out.println(cp.getTotalElements());
			System.out.println(cp.getTotalPages());
			
		}
		
		
//		System.out.println(pr.getPageNumber());
//		List<Course>courseList = coursePage.getContent();
//		courseList.forEach(System.out :: println);
//		
		
				
	}
}
