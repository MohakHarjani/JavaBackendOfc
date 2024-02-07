package vw.mohak.vw2_springboot_didemo.dimodel;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Department {
	
	@Value("10")
	private int deptId;
	
	@Value("IT")
	private String deptName;
	
	@Value("${dept.location}")
	private String deptLocation;
	private int employeeCount;
	
	private Logger lg = LoggerFactory.getLogger(Employee.class);
	//==============================================================================================
	public Department()
	{
		lg.debug("No parameter constructor of Department called");
		lg.debug("Dept details inside constructor => " + this.deptId + ", " + this.deptName +  ", " + this.deptLocation);
		
	}
	public Department(int deptId, String deptName, String deptLocation, int employeeCount) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.deptLocation = deptLocation;
		this.employeeCount = employeeCount;
	}
	//================================================================================================
	public int getDeptId() {
		lg.debug("Getter of deptId");
		return deptId;
	}
	public void setDeptId(int deptId) {
		lg.debug("Setter of deptId");
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getDeptLocation() {
		return deptLocation;
	}
	public void setDeptLocation(String deptLocation) {
		this.deptLocation = deptLocation;
	}
	public int getEmployeeCount() {
		return employeeCount;
	}
	public void setEmployeeCount(int employeeCount) {
		this.employeeCount = employeeCount;
	}
	//======================================================================================
	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", deptName=" + deptName + ", deptLocation=" + deptLocation
				+ ", employeeCount=" + employeeCount + "]";
	}
	

}
