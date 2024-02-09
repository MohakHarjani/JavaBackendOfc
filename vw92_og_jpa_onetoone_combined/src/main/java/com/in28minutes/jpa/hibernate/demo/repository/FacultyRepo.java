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


/*
 * transfer_money() -  if it completes totality, fails rollbacked chnages entirely
   op1 - withdraw act 2000,acctid 1 - dml update 1
   op2 - deposit act 2000 acctid 11 - dml update 2
                                    - commit
                                    */

@Component
@Transactional
public class FacultyRepo {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@Autowired
	EntityManager em;
	
	
	public void save(Faculty f)
	{
				
		if(f.getFacultyId()==0)
		{
		this.em.persist(f);
		logger.info("Faculty with facultyid:"+f.getFacultyId()+" persisted.");
		}
		else
		{
			this.em.merge(f);
			logger.info("Faculty with facultyid:"+f.getFacultyId()+" updated/merged.");
		}
	}
	
	public Faculty findById(int id)
	{
		Faculty f = this.em.find(Faculty.class, id);
		logger.info("Faculty with facultyid:"+f.getFacultyId()+" retrieved.");
		
		return f;
	}
	
	public void updateTotExp(int id,int totexp)
	{
		Faculty f = this.em.find(Faculty.class, id);
		logger.info("Faculty:"+f);
		f.setTotExp(totexp);
		logger.info("after updating the tot exp of faculty"+f.getTotExp());
		
	}
	
	  public List<Faculty> getAllFaculties() {
		                                         //sql query - select * from db1.courses;
		                                         //JPQL query - java persistence query language - it is object based
		  List<Faculty> lst = this.em.createQuery("select f from Faculty f",Faculty.class).getResultList(); 
			logger.info("List of all existing Faculties:"+lst);
	  
	      return lst;
	  }
	
	

}
