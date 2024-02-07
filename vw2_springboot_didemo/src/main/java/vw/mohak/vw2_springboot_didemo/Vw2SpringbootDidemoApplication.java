package vw.mohak.vw2_springboot_didemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import vw.mohak.vw2_springboot_didemo.dimodel.Department;
import vw.mohak.vw2_springboot_didemo.dimodel.Employee;


@SpringBootApplication
public class Vw2SpringbootDidemoApplication {

private static Logger lg = LoggerFactory.getLogger(Employee.class);
	
	public static void main(String[] args) {
		
     	ConfigurableApplicationContext cx = SpringApplication.run(Vw2SpringbootDidemoApplication.class, args);
     	
		Employee emp = (Employee)cx.getBean("employee");
		lg.debug("Employee = " + emp);
		
		Department dept = (Department)cx.getBean("department");
		lg.debug("Department = " + dept);
		
		Department empDept = emp.getEmpDept();
		lg.debug("EmpDept = " + empDept.getDeptId());
	}

}
