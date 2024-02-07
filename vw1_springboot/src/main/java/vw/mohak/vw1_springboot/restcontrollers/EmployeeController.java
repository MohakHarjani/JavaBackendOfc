package vw.mohak.vw1_springboot.restcontrollers;



import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import vw.mohak.vw1_springboot.daos.EmployeeDao;
import vw.mohak.vw1_springboot.models.Employee;





@RestController
public class EmployeeController {
	
	@Autowired    //injects the dependency (object of EmployeeDao class) 
	EmployeeDao empDao;
	Logger lg = LoggerFactory.getLogger(EmployeeDao.class);
	//=========================================================================================================
	
	//GET REQUESTS...
	@GetMapping("/emp/{empId}")     //url => /emp/1
	Employee getEmployee(@PathVariable int empId)
	{
		return empDao.getEmployee(empId);
	}
	//------------------------------------------------------------------------------------------
	@GetMapping("/emp")     //url => /emp?empId=1
	Employee getEmployeeByParam(@RequestParam(name = "empId", defaultValue = "0") int empid) //intentionally diff
	{
		return empDao.getEmployee(empid); 
	}
	//---------------------------------------------------------------------------------------------
	@GetMapping("/empDetails")  //url needs to be diff ...url => /empDetails?name=Mohak&deptNo=10
	Employee getEmployeeByDetails(@RequestParam(name = "name", defaultValue = "Dummy") String empName,
	                              @RequestParam (name = "dept", defaultValue = "0") int deptNo)
	{
		lg.debug(empName + ", "  + deptNo);
		return empDao.getEmployee(empName, deptNo);
	}
	//-----------------------------------------------------------------------------------------------
	@GetMapping("/emps")
	List<Employee> getEmployeeByPath()
	{
		return empDao.getAllEmployees();
	}
	
	//===========================================================================================================
	
	//POST REQUESTS...........................
	@PostMapping("/emp")  //url same as that of get.....
	boolean addEmployee(@RequestBody Employee emp)
	{
		return empDao.addEmployee(emp);
	}
	
	
	
	
	//==============================================================================================================
	
	//DELETE REQUESTS........
	@DeleteMapping("/emp")
	boolean removeEmployee(@RequestBody Employee emp)
	{
		return empDao.removeEmployee(emp);
	}
	

}
