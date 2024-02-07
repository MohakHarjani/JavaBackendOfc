package vw.mohak.vw1_springboot.daos;



import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import vw.mohak.vw1_springboot.configdemo.EmployeeConfig;
import vw.mohak.vw1_springboot.models.Employee;


//@Configuration
//@EnableConfigurationProperties(EmployeeDao.class)
@Service   
public class EmployeeDao {
	EmployeeConfig empConfig;
	
	private List<Employee>empList;
	private Logger lg = LoggerFactory.getLogger(EmployeeDao.class);
	
	@Autowired
	public EmployeeDao(EmployeeConfig empConfig)
	{
		empList = new ArrayList<Employee>();
   	    empList.add(new Employee(empConfig.getEmpId(), empConfig.getEmpName(), 
   	    		empConfig.getEmpSal(), empConfig.getDeptNo()));
		empList.add(new Employee(1, "Mohak Harjani", 35000, 10));
		empList.add(new Employee(2, "Virat Kohli", 75000, 30));
		empList.add(new Employee(3, "Rohit Sharma", 65000, 20));
		empList.add(new Employee(4, "KL Rahul", 15000, 10));
		empList.add(new Employee(5, "Jasprit Bumrah", 55000, 20));
	}
	//===================================================================================================
	public Employee getEmployee(int targetEmpId)
	{
		Employee foundEmployee = empList.stream()
		                                .filter((e)->e.getEmpId() == targetEmpId)
		                                .findFirst()
		                                .orElse(null);
		return foundEmployee;
	}
	//========================================================================================================
	public Employee getEmployee (String empName, int deptNo)
	{
		lg.debug(empName + ", " + deptNo);
		Employee foundEmployee = empList.stream()
                                        .filter((e)-> (e.getEmpName().equals(empName)) && (e.getDeptNo() == deptNo))
                                        .findFirst()
                                        .orElse(null);
		return foundEmployee;
		
	}
	//=======================================================================================================
	public List<Employee> getAllEmployees ()
	{
		return this.empList;
	}
	//========================================================================================================
	public boolean addEmployee(Employee newEmployee)
	{
		return this.empList.add(newEmployee);
	}
	//=======================================================================================================
	public boolean removeEmployee(Employee emp)
	{
		return this.empList.remove(emp);   //this works because "equals" is overriden in Employee :)
	}

}
