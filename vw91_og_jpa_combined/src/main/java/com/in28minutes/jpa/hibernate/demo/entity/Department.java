package com.in28minutes.jpa.hibernate.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Department {
	
	@Id
	@GeneratedValue
	Long deptid;
	
	String deptname;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy="department")
	List<Employee> emplst = new ArrayList<Employee>();
	
	
	public Department()
	{
		
	}

	public Department(String deptname) {
		super();
		this.deptname = deptname;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public List<Employee> getEmplst() {
		return emplst;
	}

	public void setEmplst(List<Employee> emplst) {
		this.emplst = emplst;
	}

	public Long getDeptid() {
		return deptid;
	}

	@Override
	public String toString() {
		return "Department [deptid=" + deptid + ", deptname=" + deptname  + "]";
	}
	
	
	

}
