package com.in28minutes.jpa.hibernate.demo.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "faculty_3")
public class Faculty {
	
	@Id
	@GeneratedValue
	private int facultyId;
	
	private String facultyName;
	private int experience;
	private LocalDate joiningDate;
	
   //	@OneToMany (fetch = FetchType.EAGER)
	
	//By default OneToMany relationships have a fetch type of  "LAZY"
	//even when we call "find" using EM, then also this list won't be populated
	//the list will only be populated when we call "getCourseList"....
	//...BUT GETCOURSE LIST MUST BE CALLED ON A TRACKED OBJECT INSIDE A TRANSACTION
	//....OUTSIDE A TRANSACTION AND CALLING "getCourseList" won't fetch lazily
	@OneToMany 
	@JoinTable (name = "faculty_course")   //this join table will havecourseId as PK to avoid making it ManyToMany
	private List<Course>facultyCourseList;
	
	public Faculty()
	{
		
	}
	public Faculty(String facultyName, int experince, LocalDate joiningDate) {

		this.facultyName = facultyName;
		this.experience = experince;
		this.joiningDate = joiningDate;
	}


	public Faculty(String facultyName, int experience, LocalDate joiningDate,
			List<Course> facultyCourseList) {
		super();
		this.facultyName = facultyName;
		this.experience = experience;
		this.joiningDate = joiningDate;
		this.facultyCourseList = facultyCourseList;
	}
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
	
	public List<Course> getFacultyCourseList() {
		return facultyCourseList;
	}
	public void setFacultyCourseList(List<Course> facultyCourseList) {
		this.facultyCourseList = facultyCourseList;
	}
	
	
	@Override
	public String toString() {
		return "Faculty [facultyId=" + facultyId + ", facultyName=" + facultyName + ", experince=" + experience
				+ ", joiningDate=" + joiningDate + ", CourseList = "  + facultyCourseList +  " ] ";
	}
	
	
	
	
	

}
