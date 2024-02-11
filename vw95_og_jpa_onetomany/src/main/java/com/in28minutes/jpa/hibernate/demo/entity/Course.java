package com.in28minutes.jpa.hibernate.demo.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="mycourses") //@Table is optional
public class Course {
	
	@Id
	//@GeneratedValue(strategy=SEQUENCE, generator="CUST_SEQ")

	@GeneratedValue
	int courseId; //course_id
	
	//@Column(name="cname")
	String courseName;  //course_name
	
	double coursePrice; //course_price


	public Course() {}
	
	public Course(String courseName, double coursePrice) {
		super();
		this.courseName = courseName;
		this.coursePrice = coursePrice;
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
	
		

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return courseId == other.courseId;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + 
				", coursePrice=" + coursePrice+"]";
	}


	
	
	

}
