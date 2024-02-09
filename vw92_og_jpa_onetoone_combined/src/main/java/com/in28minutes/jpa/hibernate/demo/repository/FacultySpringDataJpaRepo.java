package com.in28minutes.jpa.hibernate.demo.repository;

import com.in28minutes.jpa.hibernate.demo.entity.*;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

//@Transactional
@Repository
public interface FacultySpringDataJpaRepo extends JpaRepository<Faculty,Integer>{
//try to call count,deleteById,delete,findById
	
	
}
