package com.in28minutes.jpa.hibernate.demo.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.jpa.hibernate.demo.dao.FacultyDao;
import com.in28minutes.jpa.hibernate.demo.entity.Faculty;

@RestController
public class FacultyController {
	
	@Autowired
	FacultyDao fd;
	
	@PostMapping("/faculty/add")
	void addFaculty(@RequestBody Faculty newFaculty)
	{
		fd.addFaculty(newFaculty);
		
	}

}
