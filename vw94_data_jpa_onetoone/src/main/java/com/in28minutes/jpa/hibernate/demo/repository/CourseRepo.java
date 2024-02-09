package com.in28minutes.jpa.hibernate.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.in28minutes.jpa.hibernate.demo.entity.Course;


@Component
@Transactional
public class CourseRepo {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager em;
	
	public void save(Course course)
	{
		if (course.getCourseId() == 0)
			this.em.persist(course);
		else
			this.em.merge(course);
		logger.info("Course of " + course.getCourseId() + " saved ");
	}
	
	public Course findById(int id)
	{
		Course foundCourse = this.em.find(Course.class, id);
		logger.info("Course of " + id + " => " + foundCourse);
		
		foundCourse.setCourseName("Java");
		
		Course foundCourse1 = this.em.find(Course.class, id);
		logger.info("OKKK Course of " + id + " => " + foundCourse1);
		
		return foundCourse;
	}
	
	public void updateName(int courseId, String newName)
	{
		Course foundCourse = this.em.find(Course.class, courseId);
		foundCourse.setCourseName(newName);
	}
	 public List<Course> retrieveCourses() {
		  
		 //Course inside createQuery is for className
		 //this is not a SQL query, it is JPQL query
		 //it is object based query language
		 //Cource c....c is the instance of class
		 //all this will be done by entity manager
		  List<Course> list = em.createQuery("select c from Course c",Course.class).getResultList(); 
		  logger.info("List = " + list);
	      //for where clause c.property = 2 (similar to java obj)
	
	//print  once to lazy fetch the departments and passport of each emp in list

	  
	  return list;
	  }

}
