package com.in28minutes.jpa.hibernate.demo.restcontrollers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.in28minutes.jpa.hibernate.demo.dao.EmployeeDao;
import com.in28minutes.jpa.hibernate.demo.entity.Employee;
import com.in28minutes.jpa.hibernate.demo.exception.EmpNotFoundException;

@RequestMapping("/web/emp")
@Controller
public class EmployeeWebController {
	
	
	@Autowired
	EmployeeDao empDao;
	
	
	@GetMapping("/greet")
	String test()
	{
		return "greetall";
	}
	
	@GetMapping("/{empId}")
	String getEmployeeById(@PathVariable int empId, ModelMap model)
	{
		try {
		Employee foundEmployee = empDao.getEmployeeById(empId);
		model.addAttribute("emp", foundEmployee);
		}
		catch(EmpNotFoundException e)
		{
			model.addAttribute("errorMsg", e.getMessage());
		}
		return "empdisplay";
	}
	
	@GetMapping("/{empId}/salary")
	String getSalaryInformation(@PathVariable int empId, ModelMap model)
	{
		try {
		Employee foundEmployee = empDao.getEmployeeById(empId);
		
		model.addAttribute("salary", foundEmployee.getEmpSal());
		model.addAttribute("annualSal", foundEmployee.getAnnualSal());
		}
		catch(EmpNotFoundException e)
		{
			model.addAttribute("errorMsg", e.getMessage() + "....so salary cannot be computed :(");
		}
		return "salarydisplay";
	}
	
	@GetMapping("/register")
	String getEmpForm(Model model)
	{
		Employee emp = new Employee();
		System.out.println(emp);
		model.addAttribute("employee", emp);
		return "employeeform";
	}
	@PostMapping("/add")
	String addEmployee(@Valid @ModelAttribute("employee") Employee emp, BindingResult bindingResult, ModelMap model)
	{
		System.out.println(emp);
		if (bindingResult.hasErrors())
		{
			return "employeeform";
		}
		
		Employee savedEmp = empDao.addEmployee(emp);
		model.addAttribute("emp", savedEmp);
		return "empdisplay";
	}
	
//	@PostMapping("/empp")
//	public String addEmployee( @ModelAttribute("employee") @Valid Employee e,BindingResult bindingResult,ModelMap map)
//	{
//		if (bindingResult.hasErrors()) {
//			logger.info("employee validation failed:Returning back to empform.jsp page");
//			return "empform";
//		}
//		else
//		{
//		logger.info("postemp:"+e);
//	    Employee em = this.empdao.saveEmp(e);
//	    map.addAttribute("postedemp", em);
//	    return "postempdet";
//		}
//	}


}
