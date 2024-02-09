package com.in28minutes.jpa.hibernate.demo.repository;

import com.in28minutes.jpa.hibernate.demo.entity.*;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

//@Transactional
@Repository
public interface CourseSpringDataJpaRepo extends JpaRepository<Course,Integer>{
//try to call count,deleteById,delete,findById
	
	List<Course> findByCourseNameAndCourseId(String name, Integer id);

	List<Course> findByCourseName(String name);
	
	List<Course> findByCourseNameOrderByCourseIdDesc(String name);

	
	@Transactional
	List<Course> deleteByCourseName(String name);

	Long countByCourseName(String name);
	
	@Query("Select  c From Course c where courseName like '%Java%'")
	List<Course> courseWithPatternInCourseName();

	@Query(value = "Select  *  From Course c where courseName like '%Java%'", nativeQuery = true)
	List<Course> courseWithPatternInCourseNameUsingNativeQuery();
	

}
