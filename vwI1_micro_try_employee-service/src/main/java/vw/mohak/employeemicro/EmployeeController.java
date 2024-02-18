package vw.mohak.employeemicro;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@GetMapping("/greet")
	String greetEmployee ()
	{
		return "Hi employee from port 8000";
	}
	
	@GetMapping("/greetByName")
	String greetByParams (@RequestParam (name = "name") String empName)
	{
		return "Hi " + empName + " from port 8000";
	}


}
