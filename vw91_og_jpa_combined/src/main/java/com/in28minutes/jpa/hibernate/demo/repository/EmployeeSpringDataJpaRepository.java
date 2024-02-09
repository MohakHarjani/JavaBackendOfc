package com.in28minutes.jpa.hibernate.demo.repository;

import com.in28minutes.jpa.hibernate.demo.entity.*;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

//@Transactional
@Repository
public interface EmployeeSpringDataJpaRepository extends JpaRepository<Employee1,Long>{
//try to call count,deleteById,delete,findById
	
	List<Employee1> findByNameAndId(String name, Long id);

	List<Employee1> findByName(String name);
	
	List<Employee1> findByNameOrderByIdDesc(String name);

	@Transactional
	List<Employee1> deleteByName(String name);

	Long countByName(String name);
	
	@Query("Select  e From Employee e where name like '%y%'")
	List<Employee1> employeeWithPatternInName();

	@Query(value = "Select  *  From Employee e where name like '%y%'", nativeQuery = true)
	List<Employee1> employeeWithPatternInNameUsingNativeQuery();
	

}
