package com.in28minutes.jpa.hibernate.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in28minutes.jpa.hibernate.demo.entity.Course;
import com.in28minutes.jpa.hibernate.demo.exceptions.CourseFieldsNullException;
import com.in28minutes.jpa.hibernate.demo.repository.CourseRepo;

@Service
public class CourseDao {
	
	@Autowired
	CourseRepo cr;
	
	
	public CourseDao()
	{
		
	}
	
	public Course addCourse(Course newCourse)
	{
		System.out.println("Hi  .................." + newCourse);
		if (newCourse.getCourseName() == null || newCourse.getCoursePrice() == 0)
			throw new CourseFieldsNullException("Added Course fields should not be null");
		
		Course savedCourse = cr.save(newCourse);
		return savedCourse;
	}
	
	
	

}
