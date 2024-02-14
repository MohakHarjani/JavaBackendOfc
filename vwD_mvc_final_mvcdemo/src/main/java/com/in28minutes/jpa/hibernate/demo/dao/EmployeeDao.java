package com.in28minutes.jpa.hibernate.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in28minutes.jpa.hibernate.demo.entity.Employee;
import com.in28minutes.jpa.hibernate.demo.exception.EmpNotFoundException;
import com.in28minutes.jpa.hibernate.demo.repository.EmployeeRepo;

@Service
public class EmployeeDao {
	
	@Autowired
	private EmployeeRepo er;
	
	public Employee addEmployee(Employee newEmp)
	{
		er.save(newEmp);
		return newEmp;
	}
	
	public List<Employee> getAllEmployees()
	{
		return er.findAll();
	}
	
	public Employee getEmployeeById(int empId)
	{
		Optional<Employee> foundEmp = er.findById(empId);
		if (foundEmp.isPresent())
			return foundEmp.get();
		throw new EmpNotFoundException("Employee with id = " + empId + " not found ");
	}

}
