package com.in28minutes.jpa.hibernate.demo.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Faculty {
	
	@Id
	@GeneratedValue
	int facultyId;
	
	String facultyName;
	
	int totExp;
	
	LocalDate joinDate;
	
	//bi-directional relationship which is mapped from other side so no relational fk column will
	//be created for this field
	@OneToMany
	List<Course> courses;
	
	public Faculty() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Faculty(String facultyName, int totExp, LocalDate joinDate) {
		super();
		this.facultyName = facultyName;
		this.totExp = totExp;
		this.joinDate = joinDate;
	}

	

	public Faculty(String facultyName, int totExp, LocalDate joinDate, List<Course> courses) {
		super();
		this.facultyName = facultyName;
		this.totExp = totExp;
		this.joinDate = joinDate;
		this.courses = courses;
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

	public int getTotExp() {
		return totExp;
	}

	public void setTotExp(int totExp) {
		this.totExp = totExp;
	}

	public LocalDate getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(LocalDate joinDate) {
		this.joinDate = joinDate;
	}
	
			
	

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

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

	@Override
	public String toString() {
		return "Faculty [facultyId=" + facultyId + ", facultyName=" + facultyName + ", totExp=" + totExp + ", joinDate="
				+ joinDate + ", courses=" + courses + "]";
	}


	
	
	

}
