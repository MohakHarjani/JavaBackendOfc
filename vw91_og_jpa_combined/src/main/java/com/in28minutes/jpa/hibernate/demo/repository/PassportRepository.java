package com.in28minutes.jpa.hibernate.demo.repository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.in28minutes.jpa.hibernate.demo.entity.Passport;

@Repository
@Transactional
public class PassportRepository {
	
	
	@Autowired
	EntityManager em;

	public void insert(Passport p) {
		
		System.out.println("inside Passport Repository insert method.."+p);
	    em.persist(p);
		
	}

}
