package com.in28minutes.jpa.hibernate.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.in28minutes.jpa.hibernate.demo.entity.Course;


/*
 * transfer_money() -  if it completes totality, fails rollbacked chnages entirely
   op1 - withdraw act 2000,acctid 1 - dml update 1
   op2 - deposit act 2000 acctid 11 - dml update 2
                                    - commit
                                    */

@Component
@Transactional
public class CourseRepo {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@Autowired
	EntityManager em;
	
	
	public void save(Course c)
	{
				
		if(c.getCourseId()==0)
		{
		this.em.persist(c);
		logger.info("Course with courseid:"+c.getCourseId()+" persisted.");
		}
		else
		{
			this.em.merge(c);
			logger.info("Course with courseid:"+c.getCourseId()+" updated/merged.");
		}
	}
	
	public Course findById(int id)
	{
		Course c = this.em.find(Course.class, id);
		logger.info("Course with courseid:"+c.getCourseId()+" retrieved.");
		
		return c;
	}
	
	public void updateCourseName(int id,String name)
	{
		Course c = this.em.find(Course.class, id);
		logger.info("Course:"+c);
		c.setCourseName(name);
		logger.info("after setting the course name:"+c.getCourseName());
		
	}
	
	  public List<Course> retrieveEmployees() {
		                                         //sql query - select * from db1.courses;
		                                         //JPQL query - java persistence query language - it is object based
		  List<Course> lst = this.em.createQuery("select c from Course c",Course.class).getResultList(); 
			logger.info("List of all existing Courses:"+lst);
	  
	      return lst;
	  }
	
	

}
