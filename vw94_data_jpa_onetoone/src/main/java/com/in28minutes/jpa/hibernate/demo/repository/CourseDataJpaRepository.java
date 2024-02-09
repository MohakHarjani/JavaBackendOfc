package com.in28minutes.jpa.hibernate.demo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.in28minutes.jpa.hibernate.demo.entity.Course;
import com.in28minutes.jpa.hibernate.demo.entity.Faculty;


@Repository
public interface CourseDataJpaRepository extends JpaRepository<Course, Integer>{
	

	Course findByCourseNameAndCourseId(String courseName, Long courseId);

	Course findByCourseName(String courseName);
	
	Course findByCourseFaculty(Faculty courseFaculty);
	


	@Transactional
	List<Course> deleteByCourseName(String courseName);
	
	
	@Query("Select  c From Course c where courseName like '%ld%'")
	List<Course> courseWithPatternInName();
	
	
	//see the column name from actual table in DB
	@Query(value = "Select* from Course where course_name like '%ng%'", nativeQuery = true)
	List<Course> courseWithPatternInNameBySQL();
	

	Long countByCourseName(String courseName);
	
	
	List<Course> findByCourseNameOrderByCourseIdDesc(String name);
	

}

