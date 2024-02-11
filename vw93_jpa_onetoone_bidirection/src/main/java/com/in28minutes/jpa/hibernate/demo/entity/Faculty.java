package com.in28minutes.jpa.hibernate.demo.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "faculty_2")
public class Faculty {
	
	@Id
	@GeneratedValue
	int facultyId;
	
	String facultyName;
	int experience;
	LocalDate joiningDate;
	
	
	//If I don't write mappedBy, FK will be created in both tables
	//That won't cause a problem at relational level ...
	//But how will be create Course and Faculty object
	//For creating/saving course we would require faculty
	//For creating/saving faculty we would require course
	//Both objects, depend on each other   
	
	//So Faculty table won't be having a column for "facultyCourse"
	//Any time we want facultyCourse, it will be fetched using query
	@OneToOne (mappedBy = "courseFaculty")  //we add "fieldName" present in owning entity
	Course facultyCourse;  //faculty ka course
	
	public Faculty()
	{
		
	}
	public Faculty(String facultyName, int experince, LocalDate joiningDate) {

		this.facultyName = facultyName;
		this.experience = experince;
		this.joiningDate = joiningDate;
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
	public Course getFacultyCourse() {
		return facultyCourse;
	}
	public void setFacultyCourse(Course facultyCourse) {
		this.facultyCourse = facultyCourse;
	}


	//IF WE SPECIFY THE WHOLE COURSE OBJECT IN TO-STRING....
	//IT WILL BECOME CYCLIC...
	//FROM FACULTY WE WILL TRY TO PRINT COURSE...
	//FROM COURSE WE WILL TRY TO PRINT FAUCULT.....AND SO ON.....
	
	@Override
	public String toString() {
		return "Faculty [facultyId=" + facultyId + ", facultyName=" + facultyName + ", experince=" + experience
				+ ", joiningDate=" + joiningDate +  ", courseName = " + this.getFacultyCourse().getCourseName() + " ] ";
	}
	
	
	
	
	

}
