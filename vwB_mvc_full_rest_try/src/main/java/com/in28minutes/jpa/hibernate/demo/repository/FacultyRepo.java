package com.in28minutes.jpa.hibernate.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.in28minutes.jpa.hibernate.demo.entity.Faculty;


@Repository
public interface FacultyRepo extends JpaRepository<Faculty,Integer>{

}
