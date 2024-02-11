package com.in28minutes.jpa.hibernate.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.in28minutes.jpa.hibernate.demo.entity.Course;
import com.in28minutes.jpa.hibernate.demo.entity.Faculty;

@Component
@Transactional
public class CourseRepo {
	
	@Autowired
	EntityManager em;
	
	
	//=====================================================================================================
	public void saveCourse(Course course)
	{
		if (course.getCourseId() == 0) //means it is a pojo and not yet in db or persistence context
			this.em.persist(course);
		
		else  
			this.em.merge(course);
		//we would use merge when from App we have a retreived entry (using findBy)
		//and we want to update that retrieved entry (that entry will have a non-zero id)
		
		//course is now a tracked object...any changes done to object will be synced to DB
		course.setCoursePrice(course.getCoursePrice() + 100);
		
		
	}
	//===================================================================================================
	public Course findCourseById(int courseId)
	{
		Course foundCourse = em.find(Course.class, courseId); 
		//this foundCourse is a POJO but a tracked object 
		//this object is tracked in the persistence context
		//it will remain tracked 
		
		//any changes done to this pojo, (using simple java getter-setter)
		//will be reflected in persistence context...a
		//and after this function ends... changes will be synced with the DB
		
//		foundCourse.setCourseName("Core "  + foundCourse.getCourseName()); [IMPORTANT]
		//using setter and not EM, still after this function..changes will be reflected in DB
		
		return foundCourse;
	}
	//=========================================================================================================
	
	public void updateCoursePrice(int courseId, int newPrice)
	{
		Course foundCourse = this.findCourseById(courseId);
		foundCourse.setCoursePrice(newPrice); 
		
		//no need to merge, the update will be automatically synced to DB as foundCourse is a tracked object
	}
	
	//======================================================================================================
	
	public List<Faculty> getFacultyList(int courseId)
	{
		Course foundCourse = this.findCourseById(courseId);
		List<Faculty>facultyList = foundCourse.getCourseFacultyList();
		
		//some operation need to be done on facultyList inside transaction to populate this list
		facultyList.size(); 
		return facultyList;
		
	}
	
}
