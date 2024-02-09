package com.in28minutes.jpa.hibernate.demo.entity;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Faculty {
	
	@Id
	@GeneratedValue
	int facultyId;
	
	String facultyName;
	
	int totalExp;
	
	LocalDate joinDate;
	
	
	//this will not create column in table
	@OneToOne  (mappedBy = "courseFaculty") //field Name aega yha par....fieldName that's in Course
	Course facultyCourse;

	
	//=================================================================
	

	public Faculty(String facultyName, int totalExp, LocalDate joinDate) {
		super();
		this.facultyName = facultyName;
		this.totalExp = totalExp;
		this.joinDate = joinDate;
	}

	public Faculty() {
		super();
		// TODO Auto-generated constructor stub
	}
	//================================================

	public int getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(int facultyId) {
		this.facultyId = facultyId;
	}

	public String getFacultyName() {
		return facultyName;
	}

	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}

	public int getTotalExp() {
		return totalExp;
	}

	public void setTotalExp(int totalExp) {
		this.totalExp = totalExp;
	}

	public LocalDate getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(LocalDate joinDate) {
		this.joinDate = joinDate;
	}
	
	//======================================================================================

	public Course getFacultyCourse() {
		return facultyCourse;
	}

	public void setFacultyCourse(Course facultyCourse) {
		this.facultyCourse = facultyCourse;
	}

	

	@Override
	public String toString() {
		return "Faculty [facultyId=" + facultyId + ", facultyName=" + facultyName + ", totalExp=" + totalExp
				+ ", joinDate=" + joinDate + ", facultyCourse=" + facultyCourse.getCourseName() + "]";
	}

	//========================================================================================
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Faculty other = (Faculty) obj;
		return facultyId == other.facultyId;
	}
	
	//====================================================================================================
	

}
