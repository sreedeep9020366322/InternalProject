package project.internal.entity;

import java.sql.Date;

public class Employee {

	private String employeeName;
	private String employeeId;
	private String designation;
	//private String employeePswd;
	private String employeeAddress;
	private long employeeMobile;
	private Date dateOfJoining;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Employee(final String employeeName,final String employeeId, final String designation, 
			final String employeeAddress,final long employeeMobile,final Date dateOfJoining) {
		super();
		this.employeeName = employeeName;
		this.employeeId = employeeId;
		this.designation = designation;
	//	this.employeePswd = employeePswd;
		this.employeeAddress = employeeAddress;
		this.employeeMobile = employeeMobile;
		this.dateOfJoining = dateOfJoining;
	
		
	}
	
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
//	public String getEmployeePswd() {
//		return employeePswd;
//	}
//	public void setEmployeePswd(String employeePswd) {
//		this.employeePswd = employeePswd;
//	}
	public String getEmployeeAddress() {
		return employeeAddress;
	}
	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}
	public long getEmployeeMobile() {
		return employeeMobile;
	}
	public void setEmployeeMobile(long employeeMobile) {
		this.employeeMobile = employeeMobile;
	}
	public Date getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	@Override
	public String toString() {
		return "Employee [employeeName=" + employeeName + ", employeeId=" + employeeId + ", designation=" + designation
				+ ", employeeAddress=" + employeeAddress + ", employeeMobile=" + employeeMobile + ", dateOfJoining="
				+ dateOfJoining + "]";
	}

	


	


}
