package com.in28minutes.jpa.hibernate.demo.repository;

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
	public void updateFacultyCourse(int facultyId, Course newCourse)
	{
		Faculty foundFaculty = this.findFacultyById(facultyId);
		foundFaculty.setFacultyCourse(newCourse);
	}


}
