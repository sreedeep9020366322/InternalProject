package project.internal.daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project.internal.entity.Employee;
import project.internal.entity.Item;
import project.internal.entity.Order;
import project.internal.entity.OrderItem;
import project.internal.entity.Table;
import project.internal.ifaces.DAO;
import project.internal.utils.SqlConnection;

public class EmployeeDAO implements DAO<Employee> {

	private Connection con;

	public EmployeeDAO(Connection con) {
		super();
		this.con = con;
	}

	public EmployeeDAO() {

		super();
		con = SqlConnection.getOracleConnection();
	}

	@Override
	public int add(Employee t) {

		String sql = "insert into Employee values(?,?,?,?,?,?)";
		int rowAdded = 0;

		try {

			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, t.getEmployeeId());
			pstmt.setString(2, t.getEmployeeName());
			// pstmt.setString(3, t.getEmployeePswd());
			pstmt.setString(3, t.getDesignation());
			pstmt.setString(4, t.getEmployeeAddress());
			pstmt.setLong(5, t.getEmployeeMobile());
			pstmt.setDate(6, t.getDateOfJoining());

			rowAdded = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowAdded;
	}

	@Override
	public Employee find(String key) {
		String sql = "Select * from Employee where EmployeeId = ?";
		Employee emp = new Employee();

		try {

			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, key);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {

				emp = getEmployee(rs);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return emp;

	}

	private Employee getEmployee(ResultSet rs) {

		String employeeName = null;
		String employeeId = null;
		String employeePswd = null;
		long employeeMobile = 0;
		String designation = null;
		String employeeAddress = null;
		Date dateOfJoining = null;

		try {
			employeeName = rs.getString("EmployeeName");
			employeeId = rs.getString("EmployeeId");
			// employeePswd = rs.getString("Employee_Pswd");
			employeeMobile = rs.getInt("EmployeeMobile");
			employeeAddress = rs.getString("EmployeeAddress");
			designation = rs.getString("Designation");
			dateOfJoining = rs.getDate("DateOfJoining");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Employee cust = new Employee(employeeName, employeeId, designation, employeeAddress, employeeMobile,
				dateOfJoining);

		return cust;
	}

	@Override
	public List<Employee> findAll() {
		String sql = "Select * from Employee";
		List<Employee> employeeList = new ArrayList<Employee>();

		try {

			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				employeeList.add(getEmployee(rs));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return employeeList;
	}

	@Override
	public int update(String key, String name) {
		String sql = "Update Employee set  employeeName= ? where employeeId= ?";
		int value = 0;
		try {

			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setString(1, name);
			psmt.setString(2, key);

			value = psmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return value;
	}

	@Override
	public int delete(String key) {

		String sql = "Delete from Employee where employeeId = ?";
		int value = 0;
		try {

			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setString(1, key);

			value = psmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return value;
	}

	// public int addOrderItems(OrderItem order) {
	//
	// String sql = "Insert into
	// order_Item(orderId,itemId,quantity,orderComment,orderStatus)
	// values(?,?,?,?,?)";
	// int rowAdded = 0;
	//
	// try {
	//
	// PreparedStatement pstmt = con.prepareStatement(sql);
	//
	// pstmt.setString(1, order.getOrderId());
	// pstmt.setString(2, order.getItemId());
	// pstmt.setLong(3, order.getQuantity());
	// pstmt.setString(4, order.getOrderComment());
	// pstmt.setString(5, order.getOrderStatus());
	//
	// rowAdded = pstmt.executeUpdate();
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	// return rowAdded;
	// }

	// public int addOrderDetails(Order order) {
	//
	// String sql = "Insert into
	// orderDetails(orderId,tableId,noOfItems,orderStatus) values(?,?,?,?)";
	// int rowAdded = 0;
	//
	// try {
	//
	// PreparedStatement pstmt = con.prepareStatement(sql);
	//
	// pstmt.setString(1, order.getOrderId());
	// pstmt.setString(2, order.getTableNo());
	// pstmt.setLong(3, order.getNoOfItems());
	// pstmt.setString(4, order.getOrderStatus());
	//
	// rowAdded = pstmt.executeUpdate();
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	// return rowAdded;
	// }

	// public int addItem(Item item) {
	//
	// String sql = "Insert into Item(itemId,itemName,category,rate,itemStatus)
	// values(?,?,?,?,?)";
	// int rowAdded = 0;
	//
	// try {
	//
	// PreparedStatement pstmt = con.prepareStatement(sql);
	//
	// pstmt.setString(1, item.getItemId());
	// pstmt.setString(2, item.getItemName());
	// pstmt.setString(3, item.getItemCategory());
	// pstmt.setDouble(4, item.getItemRate());
	// pstmt.setString(5, item.getItemStatus());
	//
	// rowAdded = pstmt.executeUpdate();
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	// return rowAdded;
	// }

	// public int addTable(Table table) {
	//
	// String sql = "Insert into TableInfo(tableId,employeeId) values(?,?)";
	// int rowAdded = 0;
	//
	// try {
	//
	// PreparedStatement pstmt = con.prepareStatement(sql);
	//
	// pstmt.setString(1, table.getTableId());
	// pstmt.setString(2, table.getEmployeeId());
	//
	// rowAdded = pstmt.executeUpdate();
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	// return rowAdded;
	// }

	// public List<Item> findAllItems() {
	// String sql = "Select * from Item";
	// List<Item> itemList = new ArrayList<Item>();
	//
	// try {
	//
	// PreparedStatement pstmt = con.prepareStatement(sql);
	// ResultSet rs = pstmt.executeQuery();
	//
	// while(rs.next()) {
	//
	// itemList.add(getItems(rs));
	// }
	//
	//
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	//
	// return itemList;
	// }
	//
	// private Item getItems(ResultSet rs) {
	//
	// String itemId = null;
	// String itemName = null;
	// String itemCategory = null;
	// double itemRate = 0.0;
	// String itemStatus = null;
	// try {
	// itemName = rs.getString("itemName");
	// itemId = rs.getString("itemId");
	// itemCategory = rs.getString("category");
	// itemRate = rs.getDouble("rate");
	// itemStatus = rs.getString("itemStatus");
	//
	//
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	// Item item = new Item(itemId, itemName, itemCategory, itemRate,
	// itemStatus);
	// return item;
	// }

}
