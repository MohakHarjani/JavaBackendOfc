package com.in28minutes.jpa.hibernate.demo.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Course {
	
	@Id   //making it a primary key
	@GeneratedValue  //will automatically generate a unique id
	int courseId;
	
	String courseName;
	double coursePrice;
	
	@OneToOne
	Faculty courseFaculty;
	
	public Course()
	{
		
	}
	
	public Course( String courseName, double coursePrice) {
		super();
		this.courseName = courseName;
		this.coursePrice = coursePrice;
	}

	public Course( String courseName, double coursePrice, Faculty courseFaculty) {
		super();
		this.courseName = courseName;
		this.coursePrice = coursePrice;
		this.courseFaculty = courseFaculty;
	}
	

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
	


	public Faculty getCourseFaculty() {
		return courseFaculty;
	}

	public void setCourseFaculty(Faculty courseFaculty) {
		this.courseFaculty = courseFaculty;
	}
	



	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", coursePrice=" + coursePrice
				+ ", courseFaculty=" + courseFaculty + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		
		Course other = (Course) obj;
		return this.courseId == other.courseId;
	}
	
	
	

}
