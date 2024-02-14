package com.in28minutes.jpa.hibernate.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in28minutes.jpa.hibernate.demo.entity.Faculty;
import com.in28minutes.jpa.hibernate.demo.repository.FacultyRepo;

@Service
public class FacultyDao {
	
	@Autowired 
	FacultyRepo fr;
	
	
	public void addFaculty(Faculty newFaculty)
	{
		fr.save(newFaculty);
		
	}
	
	
	

}
