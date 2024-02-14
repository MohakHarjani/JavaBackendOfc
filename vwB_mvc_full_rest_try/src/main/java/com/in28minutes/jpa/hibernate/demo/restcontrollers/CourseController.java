package com.in28minutes.jpa.hibernate.demo.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.jpa.hibernate.demo.dao.CourseDao;
import com.in28minutes.jpa.hibernate.demo.entity.Course;

@RestController
public class CourseController {
	
	@Autowired
	CourseDao cd;
	
	
	@PostMapping("/course/add")
	Course addCourse(@RequestBody Course newCourse)
	{
		return cd.addCourse(newCourse);
	}

}
