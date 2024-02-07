package vw.mohak.vw1_springboot.configdemo;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@ConfigurationProperties("employee")
public class EmployeeConfig {
	
	private int empId;
	private String empName;
	private double empSal;
	private int deptNo;
	
	private Logger lg = LoggerFactory.getLogger(EmployeeConfig.class);
	
	public EmployeeConfig()
	{
		lg.debug("No parameter constructor of employeeConfig called");
		lg.debug("Values of field inside employeeConfig constructor = \n");
		lg.debug(empId + ", " + empName + ", " + empSal + ", " + deptNo);
		
	}
	
	public EmployeeConfig(int empId, String empName, double empSal, int deptNo) {
//		lg.debug("In the employee config constructor ");
		this.empId = empId;
		this.empName = empName;
		this.empSal = empSal;
		this.deptNo = deptNo;
	}
	//===============================================================================
	
	public double getEmpSal() {
		return empSal;
	}
	public void setEmpId(int empId) {
	    lg.debug("Setter of empId called =  " + empId );
		this.empId = empId;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public void setEmpSal(double empSal) {
		this.empSal = empSal;
	}
	public int getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}
	public int getEmpId() {
		
		return empId;
	}
	public String getEmpName() {
		return empName;
	}
	//====================================================================================

	@Override
	public String toString() {
		return "EmployeeConfig [empId=" + empId + ", empName=" + empName + ", empSal=" + empSal + ", deptNo=" + deptNo
				+ "]";
	}
	

}
