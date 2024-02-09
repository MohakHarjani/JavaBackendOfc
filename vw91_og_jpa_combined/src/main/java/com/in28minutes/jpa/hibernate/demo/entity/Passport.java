package com.in28minutes.jpa.hibernate.demo.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Passport1")
public class Passport {
	
	
	@Id
	@GeneratedValue
	int passportId;
	
	//mappedBy mentions that foreign-key column is mapped on other-side i.e. Employee side of the table by passport field
	@OneToOne(mappedBy="passport")
	Employee e;
	
	String number;
	
	LocalDate date;
	
	public Passport()
	{
		
	}

	public Passport(String number, LocalDate date) {
		super();
		this.number = number;
		this.date = date;
	}

	public int getPassportId() {
		return passportId;
	}


	public Employee getE() {
		return e;
	}

	public void setE(Employee e) {
		this.e = e;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Passport [passportId=" + passportId + ", number=" + number + ", date=" + date + "]";
	}
	
	
	
	
	
	

}
