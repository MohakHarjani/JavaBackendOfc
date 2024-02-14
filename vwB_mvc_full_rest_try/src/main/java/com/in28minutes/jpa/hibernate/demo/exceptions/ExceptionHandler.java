package com.in28minutes.jpa.hibernate.demo.exceptions;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class ExceptionHandler extends ResponseEntityExceptionHandler{
	
	//making body of response as a MAP
	public ResponseEntity<Map> handleCourseFieldsNullException(CourseFieldsNullException e)
	{
        Map<String, Object> resMap = new HashMap<>();
        resMap.put("timestamp", LocalDateTime.now());
        resMap.put("message", e.getMessage());

        return new ResponseEntity<Map>(resMap, HttpStatus.NOT_FOUND);
	}

}
