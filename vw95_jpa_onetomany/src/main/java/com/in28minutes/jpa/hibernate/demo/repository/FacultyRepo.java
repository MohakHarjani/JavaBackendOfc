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
public class FacultyRepo {
	
	@Autowired
	EntityManager em;
	
	public void saveFaculty(Faculty faculty)
	{
		if (faculty.getFacultyId() == 0)
			em.persist(faculty);
		else
			em.merge(faculty);
	}
	//=================================================================================
	public Faculty findFacultyById(int facultyId)
	{
		Faculty foundFaculty = em.find(Faculty.class, facultyId);
		return foundFaculty;
	}
	//====================================================================================
	public void updateFacultyExperience(int facultyId, int facultyExp)
	{
		Faculty foundFaculty = this.findFacultyById(facultyId);
		foundFaculty.setExperience(facultyExp);
	}
	//===================================================================================
	public List<Course> getCourseList(int facultyId)
	{
		Faculty foundFaculty = this.findFacultyById(facultyId);
		List<Course> courseList =  foundFaculty.getFacultyCourseList(); 
		//The shocking part is that even now the courseList is not populated   :(
		//"courseList" is still a proxy, and doesn't have Courses populated.....
		//CourseList won't be populated until you do some operation on courseList that to inside this transaction...
		//if you directly return courseList....It will give lazy initialization error
		
		//So you have to first populate this courseList here only by doing "any" operation on courseList
		//either courseList.size(), courseList.get(0), or println(coursList) here only........
		//then only a join query b/w (faculty_course(JOIN TABLE)) and (course_table) will be fired
		
		
		courseList.size(); //JUST TO POPULATE COURSE LIST, WHICH ISN'T POPULATED YET
		
		return courseList;
	}
	
	//===========================================================================================================
	


}
