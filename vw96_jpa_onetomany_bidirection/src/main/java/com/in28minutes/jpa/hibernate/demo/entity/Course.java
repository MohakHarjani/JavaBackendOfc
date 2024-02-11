package com.in28minutes.jpa.hibernate.demo.entity;

import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//MANY COURSES MAP TO ONE FACULTY
@Entity
@Table(name = "course_4")
public class Course {
	
	@Id
	@GeneratedValue
	private int courseId;
	
	private String courseName;
	private double coursePrice;
	
	//this will become the owning side of relationship.... (it is better also)
	//Course table will have a FK  for courseFaculty....
	//Now no need of creating an extra join table....list of courses for a faculty could now be automatically fetched
	//There is no option of "mappedBy" in manyToOne (it makes sense also :) )
	@ManyToOne 
	private Faculty courseFaculty; //one Course has only one faculty

	public Course ()
	{
		
	}
	
	public Course(String courseName, double coursePrice) 
	{
		this.courseName = courseName;
		this.coursePrice = coursePrice;
	}


	//=========================================================================================
	public int getCourseId() {
		return courseId;
	}


	public void setCourseId(int courseId) {
		
		this.courseId = courseId;
	}


	public String getCourseName() {
		return courseName;
	}


	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}


	public double getCoursePrice() {
		return coursePrice;
	}

	public void setCoursePrice(double coursePrice) {
		
		this.coursePrice = coursePrice;
	}

	public Faculty getCourseFaulty() {
		return courseFaculty;
	}

	public void setCourseFaulty(Faculty courseFaulty) {
		this.courseFaculty = courseFaulty;
	}
	//========================================================================================================
	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", coursePrice=" + coursePrice
				+ ", faculty = " + getCourseFaulty() + "]";
	}
	@Override
	public boolean equals(Object newCourse)
	{
		if (newCourse instanceof Course)
		{
			int existingCourseId = this.courseId;
			int newCourseId = ((Course) newCourse).courseId;
			return (existingCourseId == newCourseId);
		}
		return false;
	}
	
	//================================================================================================================
	
}
