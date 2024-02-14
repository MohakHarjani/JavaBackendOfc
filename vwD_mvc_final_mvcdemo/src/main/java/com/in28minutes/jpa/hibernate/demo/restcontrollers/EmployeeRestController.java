package com.in28minutes.jpa.hibernate.demo.restcontrollers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.jpa.hibernate.demo.dao.EmployeeDao;
import com.in28minutes.jpa.hibernate.demo.entity.Employee;


@RequestMapping("/rest/emp")
@RestController
public class EmployeeRestController {
	
	@Autowired
	EmployeeDao empDao;
	
	@PostMapping("/add")
	Employee addEmployee(@Valid @RequestBody Employee newEmp)
	{
		return empDao.addEmployee(newEmp);
	}
	
	@GetMapping("/all")
	List<Employee> getAllEmployees()
	{
		return empDao.getAllEmployees();
	}
	
	@GetMapping("/{empId}")
	Employee getEmployeeById(@PathVariable int empId)
	{
		return empDao.getEmployeeById(empId);
	}

}
