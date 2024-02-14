package com.in28minutes.jpa.hibernate.demo.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.in28minutes.jpa.hibernate.demo.entity.Course;

@Repository
public interface CourseRepo extends JpaRepository<Course,Integer>{
	
	
	
	

}
