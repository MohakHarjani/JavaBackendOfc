package com.in28minutes.jpa.hibernate.demo.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "faculty_1")
public class Faculty {
	
	@Id
	@GeneratedValue
	int facultyId;
	
	String facultyName;
	int experience;
	LocalDate joiningDate;

	
	public Faculty()
	{
		
	}
	public Faculty(String facultyName, int experince, LocalDate joiningDate) {

		this.facultyName = facultyName;
		this.experience = experince;
		this.joiningDate = joiningDate;
	}

	//================================================================================================
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


	public int getExperience() {
		return experience;
	}


	public void setExperience(int experience) {
		this.experience = experience;
	}


	public LocalDate getJoiningDate() {
		return joiningDate;
	}


	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}


	
	//================================================================================================

	@Override
	public String toString() {
		return "Faculty [facultyId=" + facultyId + ", facultyName=" + facultyName + ", experince=" + experience
				+ ", joiningDate=" + joiningDate + "]";
	}
	
	
	//====================================================================================================
	
	
	
	

}
