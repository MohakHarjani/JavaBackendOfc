package com.in28minutes.jpa.hibernate.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class Project {
	
	@Id
	@GeneratedValue
	Long id;
	
	String projName;
	

	@ManyToMany(mappedBy="projlst")
	List<Employee> lstemp = new ArrayList<Employee>();
	
	public Project()
	{
		
	}

	public Project(String projName) {
		super();
		this.projName = projName;
	}

	public String getProjName() {
		return projName;
	}

	public void setProjName(String projName) {
		this.projName = projName;
	}

	public List<Employee> getLstemp() {
		return lstemp;
	}

	public void setLstemp(List<Employee> lstemp) {
		this.lstemp = lstemp;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", projName=" + projName + "]";
	}
	
	

}
