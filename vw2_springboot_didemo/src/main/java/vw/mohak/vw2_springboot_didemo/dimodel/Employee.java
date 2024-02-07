package vw.mohak.vw2_springboot_didemo.dimodel;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Employee {
	private int empId;
	private String empName;
	private double empSal;
	
	private Department empDept;
	
	private Logger lg = LoggerFactory.getLogger(Employee.class);
	//========================================================================
	public Employee()
	{
		lg.debug("No parameter constructor of Employee called");
	}
	
	@Autowired
	public Employee(@Value("${employee.empId}") int empId, 
			        @Value("${employee.empName}") String empName, 
			        @Value("${employee.empSal}")  double empSal, 
			        Department empDept) 
	{
		System.out.println("In the employee constructor (bean demo)");
		this.empId = empId;
		this.empName = empName;
		this.empSal = empSal;
		this.empDept = empDept;
	}
	//===============================================================================
	public double getEmpSal() {
		return empSal;
	}
	public void setEmpSal(double empSal) {
		this.empSal = empSal;
	}
	
	public Department getEmpDept() {
		return empDept;
	}

	public void setEmpDept(Department empDept) {
		this.empDept = empDept;
	}

	public int getEmpId() {
		return empId;
	}
	public String getEmpName() {
		return empName;
	}
	//====================================================================================================
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empSal=" + empSal 
				+ ", empDept=" + empDept + "]";
	}
	
	@Override
	public boolean equals(Object obj)
	{

		if (obj instanceof Employee)
		{
			return ((Employee)obj).empId == this.empId;
		}
		return false; 
		
	}
	//====================================================================================================
	double getAnnualSal ()
	{
		return this.getEmpSal() * 12;
	}
	void empSpecific() 
	{
		System.out.println("This is an employee specific function ");
	}
	//=====================================================================================================


}
