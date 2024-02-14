package com.in28minutes.jpa.hibernate.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.in28minutes.jpa.hibernate.demo.entity.Employee;


@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

}
