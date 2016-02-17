package project.internal.entity;

public class EmployeeCredentials {

	private String EmployeeId;
	private String EmployeePswd;
	
	public EmployeeCredentials(String employeeId, String employeePswd) {
		super();
		EmployeeId = employeeId;
		EmployeePswd = employeePswd;
	}
	public EmployeeCredentials() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getEmployeeId() {
		return EmployeeId;
	}
	public void setEmployeeId(String employeeId) {
		EmployeeId = employeeId;
	}
	public String getEmployeePswd() {
		return EmployeePswd;
	}
	public void setEmployeePswd(String employeePswd) {
		EmployeePswd = employeePswd;
	}
	@Override
	public String toString() {
		return "EmployeeCredentials [EmployeeId=" + EmployeeId + ", EmployeePswd=" + EmployeePswd + "]";
	}
	

	
}
