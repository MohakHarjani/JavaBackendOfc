package com.in28minutes.jpa.hibernate.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.in28minutes.jpa.hibernate.demo.entity.Course;
import com.in28minutes.jpa.hibernate.demo.entity.Faculty;

@Transactional
@Component
public class FacultyRepo {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager em;
	
	public void save(Faculty f)
	{
		if (f.getFacultyId() == 0)
			this.em.persist(f);
		else
			this.em.merge(f);
		
		logger.info("Faculty with " + f.getFacultyId() + " saved ");
	}
	
	public Faculty findById(int id)
	{
		Faculty foundFac = em.find(Faculty.class, id);
		logger.info("Fculty of " + id + " => " + foundFac);
		
		return foundFac;
	}
	
	public void updateExperience(int facultyId, int totalExp)
	{
		Faculty foundFac = this.em.find(Faculty.class, facultyId);
		foundFac.setTotalExp(totalExp);
	}
	 public List<Faculty> getAllFaculties() {
		  
		 //Course inside createQuery is for className
		 //this is not a SQL query, it is JPQL query
		 //it is object based query language
		 //Cource c....c is the instance of class
		 //all this will be done by entity manager
		  List<Faculty> list = em.createQuery("select f from Faculty f",Faculty.class).getResultList(); 
		  logger.info("List = " + list);
	      //for where clause c.property = 2 (similar to java obj)
	
	//print  once to lazy fetch the departments and passport of each emp in list

	  
	  return list;
	  }

}
