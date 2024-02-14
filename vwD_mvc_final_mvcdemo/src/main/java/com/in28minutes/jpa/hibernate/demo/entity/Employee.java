package com.in28minutes.jpa.hibernate.demo.entity;



import java.time.LocalDate;
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
import javax.validation.constraints.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table (name = "new_emp")
public class Employee {
	
	@Id
	@GeneratedValue
	private int empId;
	
	@NotNull
	@NotBlank (message = "Employee name is mandatory")
	@Size(min = 4, message = "Name should have atleast 2 chars")
	private String empName;
	
	@NotNull(message = "emp salary is mandatory")
	private double empSal;
	
//	@NotNull (message = "emp joining date is mandatory")
//	@Future (message = "joining has to be a future date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate joiningDate;
	
	public Employee()
	{
		//joiningDate = LocalDate.now();
	}
	
	
	public Employee(String empName, double empSal, LocalDate joiningDate) {
		this.empName = empName;
		this.empSal = empSal;
		this.joiningDate = LocalDate.now();
	}


//	public Employee(int empId, String empName, double empSal) {
//		super();
//		this.empId = empId;
//		this.empName = empName;
//		this.empSal = empSal;
//	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public double getEmpSal() {
		return empSal;
	}
	public void setEmpSal(double empSal) {
		this.empSal = empSal;
	}
	
	public LocalDate getJoiningDate() {
		return joiningDate;
	}


	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}
	
	public double getAnnualSal()
	{
		return this.empSal * 12;
	}
	public double getAnnualSal(double bonus)
	{
		return (this.empSal * 12) + bonus;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empSal=" + empSal + ", joiningDate="
				+ joiningDate + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return empId == other.empId && Objects.equals(empName, other.empName)
				&& Double.doubleToLongBits(empSal) == Double.doubleToLongBits(other.empSal);
	}
	
	
	
	
	

}
