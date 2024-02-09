package com.in28minutes.jpa.hibernate.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.in28minutes.jpa.hibernate.demo.entity.Course;
import com.in28minutes.jpa.hibernate.demo.entity.Faculty;
import com.in28minutes.jpa.hibernate.demo.repository.CourseRepo;
import com.in28minutes.jpa.hibernate.demo.repository.CourseSpringDataJpaRepo;
import com.in28minutes.jpa.hibernate.demo.repository.FacultyRepo;
import com.in28minutes.jpa.hibernate.demo.repository.FacultySpringDataJpaRepo;

import java.time.LocalDate;
import java.util.*;


@SpringBootApplication
public class DemoApplication1 implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CourseSpringDataJpaRepo cr;
	
	@Autowired
	FacultySpringDataJpaRepo fr;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		
		
		
		//String facultyName, int totExp, LocalDate joinDate
		Faculty f1 = new Faculty(1,"Nisha Tyagi",15,LocalDate.now());
		fr.save(f1);
	
		Faculty f2 = new Faculty(2,"Swati Rao",15,LocalDate.now());
		fr.save(f2);
		
		Faculty f3 = new Faculty(3,"Swati Rao",15,LocalDate.now());
		fr.save(f3);
		
		Faculty f4 = new Faculty(4,"Swati Rao",15,LocalDate.now());
		fr.save(f4);
		
		
		Course c = new Course(101,"Core Java",15000);
		c.setCourseFaculty(f1);
		cr.save(c);
		
	
		
		c = new Course(102,"Core Java",20000);
		c.setCourseFaculty(f2);
		cr.save(c);
		
		c = new Course(103,"JPA",25000);
		c.setCourseFaculty(f3);
		cr.save(c);
		
		c = new Course(104,"SpringBoot",35000);
		c.setCourseFaculty(f4);
		cr.save(c);
		
		Optional<Course> opc1 = cr.findById(102);
		if(opc1.isPresent())
		{
		 	Course c1 = opc1.get();
		 System.out.println("course:"+c1.getCourseName()+" has faculty:"+c1.getCourseFaculty());
		}
		else
		System.out.println("course with Id 102 is not present/found!");
		
	
		
		Optional<Faculty> fa = fr.findById(1);
		if(fa.isPresent())
		{
		Faculty fc = fa.get();
	   	System.out.println("faculty:"+fc.getFacultyName()+" teaches course:"+fc.getCourse());
		}
		
		
		List<Course> lst = cr.findByCourseName("Core Java");
		lst.forEach(System.out::println);
		
		lst = cr.findByCourseNameOrderByCourseIdDesc("Core Java");
		lst.forEach(System.out::println);
		
		System.out.println("get courses with Pattern %Java%:");
		//pattern = %Java%
		lst = cr.courseWithPatternInCourseName();
		lst.forEach(System.out::println);
		
				
	//	lst = cr.deleteByCourseName("Core Java");
	//	lst.forEach(System.out::println);
	//	System.out.println("After deleting course with course name:'Core Java'");
		
		lst = cr.findAll();
		lst.forEach(System.out::println);
		
		long ct = cr.countByCourseName("SpringBoot");
		System.out.println("No. of Spring Boot courses as of now:"+ct);
		
		logger.info("Sorted Courses based on price in ascending order:");
		Sort sort = Sort.by(Sort.Direction.ASC, "coursePrice");
		lst = cr.findAll(sort);
		lst.forEach(System.out::println);
		
		logger.info("Sorted Courses Pagewise based on price in ascending order:");
        System.out.println("Page 1:");
		List<Course> lst1 = getAllCoursesByPaging(1,2,"coursePrice");
		lst1.forEach(System.out::println);
		System.out.println("Page 2:");
		lst1 = getAllCoursesByPaging(2,2,"coursePrice");
	    lst1.forEach(System.out::println);
	}
     public List<Course> getAllCoursesByPaging(Integer pageNo, Integer pageSize, 
		                                                           String sortBy)
      {	//pageNo: The current page number,pageSize: Number of records on each page.
        PageRequest paging = PageRequest.of(pageNo-1, pageSize, Sort.by(sortBy));
        Page<Course> pagedResult = cr.findAll(paging);
          if(pagedResult.hasContent()) {
              return pagedResult.getContent();
           } else {
              return new ArrayList<Course>();
           }
      }
}
