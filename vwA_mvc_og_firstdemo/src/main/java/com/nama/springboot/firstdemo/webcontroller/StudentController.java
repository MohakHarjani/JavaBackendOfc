package com.nama.springboot.firstdemo.webcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nama.springboot.firstdemo.model.Book;
import com.nama.springboot.firstdemo.model.Student;

@Controller
public class StudentController {
	
	//@Qualifier("stud1")
	@Autowired
	Student s;
	
	 // inject via application.properties
    @Value("${welcome.message}")
    private String message;

    @GetMapping("/")
    public String greet(ModelMap model) {
    	
    	System.out.println("inside greet..");
        model.addAttribute("message", message);
      
        return "welcome"; //view
    }

    
	@GetMapping("/getstudent")
	public String getStudentDetails(ModelMap model)
	{
		
		System.out.println("inside getstudent..");
		  model.addAttribute("student",s);
          return "student";
		
	}
	
}