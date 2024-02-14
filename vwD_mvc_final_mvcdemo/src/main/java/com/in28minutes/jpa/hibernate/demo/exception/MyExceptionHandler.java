package com.in28minutes.jpa.hibernate.demo.exception;

import java.util.HashMap;
import java.util.Map;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(EmpNotFoundException.class)
	ResponseEntity<Map> empNotFoundHandler(EmpNotFoundException e)
	{
		Map<String, String> responseMap = new HashMap<>();
		responseMap.put("message", e.getMessage());
		return new ResponseEntity<Map>(responseMap, HttpStatus.NOT_EXTENDED);
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	ResponseEntity<Map> constraintViolation(ConstraintViolationException e)
	{
		System.out.println("OKlllllllll");
		Map<String, String> responseMap = new HashMap<>();
		responseMap.put("message", e.getMessage());
		return new ResponseEntity<Map>(responseMap, HttpStatus.NOT_EXTENDED);
	}
////	MethodArgumentNotValidException
//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	ResponseEntity<Map> methodArgViolation1(MethodArgumentNotValidException e)
//	{
//	
//		
//	}
	

//	@ExceptionHandler(jakarta.validation.ConstraintViolationException.class)
//			ResponseEntity<Object> handleRuntimeException(jakarta.validation.ConstraintViolationException ex)
//			{
//				Map<String, Object> body = new LinkedHashMap<String, Object>();
//				body.put("TimeStamp", LocalDateTime.now());
//				body.put("Message", "bean validation exception: "+ex.getMessage());
//				
//				return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
//			}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request)
	{
		Map<String, String> responseMap = new HashMap<>();
		responseMap.put("message", ex.getMessage() + " from rest ");
		return new ResponseEntity<>(responseMap, HttpStatus.NOT_EXTENDED);
	}

	
	
}
