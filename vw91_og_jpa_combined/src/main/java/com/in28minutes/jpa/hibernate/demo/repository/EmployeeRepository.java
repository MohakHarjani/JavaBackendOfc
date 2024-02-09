package com.in28minutes.jpa.hibernate.demo.repository;



import java.time.LocalDate;
import java.util.List;

// Change from javax to jakarta
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

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
public class EmployeeRepository {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	

	@Autowired
	EntityManager em;
	
	@Autowired
	ProjectRepository projrepo;
	
    

	public void insert(Employee employee) {
		em.persist(employee);
		
		
	//	employee.setName("namita");
	//	employee.setSalary(7000);
	    
		
	}
	

	public Employee findById(Long id) {
		Employee emp = em.find(Employee.class, id);
		
		logger.info("Employee -> {}", emp);
		return emp;
	}
	
	
	public Department findDepartmentOfEmployee(Long id)
	{
	    Employee emp = em.find(Employee.class, id);
		
		Department d = emp.getDepartment();
		System.out.println("empid id:"+id+"'s department:"+d);
		
		return d;
	}
	
	
	public void saveEmployeeWithPassportAndDepartment(Passport p,Department d,Passport p1)
	{
		
		
		//both employee e and e1 belong to HR department
		  
		  Employee e = new Employee("Ram",5000.0);
		  
		  //one-to-one relationship
		  e.setPassport(p);
		  
		  
		  e.setDepartment(d);
		
		  
		  System.out.println("before persisting:"+e);
		  
		  insert(e);
		
         Employee e1 = new Employee("Shyam",7000.0);
		  
		  e1.setPassport(p1);
		  e1.setDepartment(d);
		
		  
		  
		  System.out.println("before persisting:"+e1);
		  
		  insert(e1);
		  
		 
	}
	
	public Employee save(Employee e) {

		if (e.getId() == null) {
			em.persist(e);
		} else {
			em.merge(e);
		}

		return e;
	}
	
	
	public void saveEmployeeWithPassportDepartmentProject(Department d,Passport p,Passport p1,Project pr,Project pr1)
	{
		
		//both employee e and e1 belong to HR department
		  
		  Employee e = new Employee("Ram",5000.0);
		  
		  //one-to-one relationship
		  e.setPassport(p);
		  
		  
		  e.setDepartment(d);
		  
		  e.getProjlst().add(pr);
		  e.getProjlst().add(pr1);
		
		//  pr.getLstemp().add(e);
		//  pr1.getLstemp().add(e);
		  
		
		  
		  System.out.println("before persisting:"+e);
		  
		  insert(e);
		
       Employee e1 = new Employee("Shyam",7000.0);
		  
		  e1.setPassport(p1);
		  e1.setDepartment(d);
		  e1.getProjlst().add(pr);
		  
		  
		  System.out.println("before persisting:"+e1);
		  
		  insert(e1);
		  
		 
		
	}

	/*
	 * public Employee save(Employee e) {
	 * 
	 * if (e.getId() == null) { em.persist(e); } else {
	 * 
	 * System.out.println("inside merge"); em.merge(e);
	 * 
	 * }
	 * 
	 * return e; }
	 * 
	 * public void deleteById(Long id) { Employee e = findById(id); em.remove(e); }
	 * 
	 * public void playWithEntityManager() { Employee e1 = new
	 * Employee("Namrata",6700); em.persist(e1);
	 * 
	 * Employee ex = findById(1L);
	 * 
	 * ex.setName("xxx"); ex.setSalary(100);
	 * 
	 * }
	 */
	  
	  
	  
	  
	  
	  public List<Employee> retrieveEmployees() {
	  
		  /*
	 	  TypedQuery<Employee> typ = em.createQuery("select e from Employee e",Employee.class);
	 	  
	 	  List<Employee> e = typ.getResultList(); 
	     */
		    
		  List<Employee> e = em.createQuery("select e from Employee e",Employee.class).getResultList(); 
		  
	  
	//print it once to lazy fetch the departments and passport of each emp in list
	   System.out.println(e); 
	  
	  return e;
	  }
	  
	  
	  public List<Employee> retrieveEmployeesUsingNamedQuery()
	  {
		  System.out.println("executing named query: query all emps..");
		  Query query = em.createNamedQuery("query_all_emps");
			List<Employee> resultList = query.getResultList();
			                         			
			logger.info("Select  e  From Employee e -> {}", resultList);
			return resultList;
	  }
	  
	  public List<Employee> retrieveEmployeesUsingNamedQuery1()
	  {
		  System.out.println("executing named query: query_emp_on_name..");
		  Query query = em.createNamedQuery("query_emp_on_name");
			List<Employee> resultList = query.getResultList();
			
			logger.info("Select  e  From Employee e  where e.name like '%y%' -> {}", resultList);
			return resultList;
	  }
	  
	  
	  public List<Project> listAllProjectsOfEmp(Long id)
	  {
		  Employee e = findById(id);
		  
		  List<Project> lst = e.getProjlst();
		  System.out.println("Employee:"+e.getName()+" is working in following projects:"+lst);
		  
		  return lst;
	  }

}