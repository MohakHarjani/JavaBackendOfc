package com.in28minutes.jpa.hibernate.demo.repository;



import java.time.LocalDate;
import java.util.List;

// Change from javax to jakarta
import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.in28minutes.jpa.hibernate.demo.entity.Department;
import com.in28minutes.jpa.hibernate.demo.entity.Employee;
import com.in28minutes.jpa.hibernate.demo.entity.Passport;
import com.in28minutes.jpa.hibernate.demo.entity.Project;

@Repository
@Transactional
public class ProjectRepository {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	

	@Autowired
	EntityManager em;
	
    

	public void insert(Project p) {
		System.out.println(p);
		em.persist(p);
		
	
	}
	
	public Project save(Project p) {

		if (p.getId() == null) {
			em.persist(p);
		} else {
			em.merge(p);
		}

		return p;
	}

	

	public Project findById(Long id) {
		Project p = em.find(Project.class, id);
		
		logger.info("Project -> {}", p);
		return p;
	}
	
	public void listAllEmployees(Long projid)
	{
		Project pr = findById(projid);
		System.out.println(pr);
		 List<Employee> ls = pr.getLstemp();  //lazy fetching
		  System.out.println("employees of Project:"+pr.getProjName()+" are:"+ls);
		  
	}

	


}