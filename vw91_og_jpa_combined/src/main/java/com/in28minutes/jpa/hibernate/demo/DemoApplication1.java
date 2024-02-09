package com.in28minutes.jpa.hibernate.demo;



import java.time.LocalDate;
import java.util.List;

import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import com.in28minutes.jpa.hibernate.demo.entity.Department;
import com.in28minutes.jpa.hibernate.demo.entity.Employee;
import com.in28minutes.jpa.hibernate.demo.entity.Employee1;
import com.in28minutes.jpa.hibernate.demo.entity.Passport;
import com.in28minutes.jpa.hibernate.demo.entity.Project;
import com.in28minutes.jpa.hibernate.demo.repository.DepartmentRepository;
import com.in28minutes.jpa.hibernate.demo.repository.EmployeeRepository;
import com.in28minutes.jpa.hibernate.demo.repository.EmployeeSpringDataJpaRepository;
import com.in28minutes.jpa.hibernate.demo.repository.PassportRepository;
import com.in28minutes.jpa.hibernate.demo.repository.ProjectRepository;


@SpringBootApplication
public class DemoApplication1 implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());


	@Autowired
	private EmployeeSpringDataJpaRepository repo;


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		
		Employee1 e = new Employee1("Anita",7000);
		
		repo.save(e);
		Employee1 e1 = new Employee1("Anita",17000);
		
		repo.save(e1);
		
		Employee1 e2 = new Employee1("Sunita",9000);
		
		repo.save(e2);
		
		Employee1 e3 = new Employee1("Divya",6000);
		
		repo.save(e3);
		
	   
		
	  //  System.out.println(repo.findById(9L));
		
		logger.info("Employee Total count -> {} ", repo.count());
	    System.out.println("count no of employees based on name:"+repo.countByName("Anita"));
	    
	    System.out.println("retrieve employee based on name and order:"+repo.findByNameOrderByIdDesc("Anita"));
	    
	    
		Sort sort = Sort.by(Sort.Direction.ASC, "name");
		logger.info("Sorted Employees based on names in ascending order: -> {} ", repo.findAll(sort));
		
		
	   // repo.delete(e3);
		
		System.out.println(repo.count());
		
		repo.deleteByName("Divya");
		
		System.out.println(repo.count());
		
		System.out.println(repo.findAll());
	  

		
	}
}
