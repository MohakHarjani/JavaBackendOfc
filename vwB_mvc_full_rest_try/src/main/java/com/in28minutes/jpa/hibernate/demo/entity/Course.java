package com.in28minutes.jpa.hibernate.demo.entity;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
@Table(name = "course_7")
public class Course {
	
	@Id
	@GeneratedValue
	private int courseId;
	
	@Column(nullable = false)
	private String courseName;
	private double coursePrice;
	
	//non-owning side
	@ManyToMany (mappedBy = "facultyCourseList")
	List<Faculty>courseFacultyList;
	
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
	public List<Faculty> getCourseFacultyList() {
		return courseFacultyList;
	}

	public void setCourseFacultyList(List<Faculty> courseFacultyList) {
		this.courseFacultyList = courseFacultyList;
	}
	
	
	//==============================================================================================================

	

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", coursePrice=" + coursePrice
				+  "]";
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