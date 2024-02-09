package com.in28minutes.jpa.hibernate.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.in28minutes.jpa.hibernate.demo.entity.Department;
import com.in28minutes.jpa.hibernate.demo.entity.Employee;


@Repository
@Transactional
public class DepartmentRepository  {
	
	
		private Logger logger = LoggerFactory.getLogger(this.getClass());
		
		

		@Autowired
		EntityManager em;
		
	    

		public void insert(Department d) {
			em.persist(d);
			
				 
			
		}
		

		public Department findById(Long id) {
			Department d= em.find(Department.class, id);
			
			logger.info("Department -> {}", d);
			return d;
		}
		
		public Department save(Department d) {
			  
			 if (d.getDeptid() == null) { em.persist(d); } else
			 {
			 
			 System.out.println("inside merge"); em.merge(d);
			 
			 }
			  
			  return d; 
		  }

		
		public void listAllEmployees(Long deptid)
		{
			Department d = findById(deptid);
			
			 List<Employee> ls = d.getEmplst();  //lazy fetching
			  System.out.println("employees of department 'HR':"+ls);
			  
		}

}
