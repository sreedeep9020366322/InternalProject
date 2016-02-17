package project.internal.entity;

public class Table {

	private String tableId;
	private String employeeId;
	
	
	public Table(String tableId, String employeeId) {
		super();
		this.tableId = tableId;
		this.employeeId = employeeId;
	}
	public Table() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getTableId() {
		return tableId;
	}
	public void setTableId(String tableId) {
		this.tableId = tableId;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	@Override
	public String toString() {
		return "Table [tableId=" + tableId + ", employeeId=" + employeeId + "]";
	}
	
	
}
