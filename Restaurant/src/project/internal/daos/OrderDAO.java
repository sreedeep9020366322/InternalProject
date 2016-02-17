package project.internal.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import project.internal.entity.Item;
import project.internal.entity.Order;
import project.internal.ifaces.DAO;
import project.internal.utils.SqlConnection;

public class OrderDAO  implements DAO<Order> {

	private Connection con;
	
	
	public OrderDAO(Connection con) {
		super();
		this.con = con;
	}

	public OrderDAO() {
		super();
		con = SqlConnection.getOracleConnection();
	}

	@Override
	public int add(Order order) {
		String sql = "Insert into orderDetails(orderId,tableId,noOfItems,orderStatus) values(?,?,?,?)";
		int rowAdded = 0;
		
		try {
		
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, order.getOrderId());
			pstmt.setString(2, order.getTableNo());
			pstmt.setLong(3, order.getNoOfItems());
			pstmt.setString(4, order.getOrderStatus());
			
			rowAdded = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return rowAdded;
	}

	@Override
	public Order find(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(String key, String name) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String key) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public int updateOrderStatus(String newStatus,String key) {
		
		String sql = "update OrderDetails set orderStatus = ? where orderId = ?";
		int rowAdded = 0;
		try {
		
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setString(1, newStatus);
			psmt.setString(2, key);
			rowAdded = psmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rowAdded;
	}
	
	public int updateOrderStatusAuto(String key) {
		
		int rowAdded = 0;
		String sql1 = "select orderStatus from order_item where orderId = ?";
		String sql2 = "update orderDetails set orderStatus = ? where orderId = ?";
		boolean flag = true;
		try {
			
			PreparedStatement psmt = con.prepareStatement(sql1);
			psmt.setString(1, key);
			ResultSet resultSet1 = psmt.executeQuery();
			while(resultSet1.next()) {
				if(!resultSet1.getString("orderStatus").equalsIgnoreCase("Completed")) {
					flag = false;
					break;
				}		
			}
			
			if(flag) {
				
				psmt = con.prepareStatement(sql2);
				psmt.setString(1, "Completed");
				psmt.setString(2, key);
				
				rowAdded = psmt.executeUpdate();
			}
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rowAdded;
	}
	
	
	public List<Item> getItemsOrdered(String orderId) {
	
		String sql1 = "Select distinct itemId from order_item where orderId = ?";
		String sql2 = "Select * from Item where itemId = ?";
		List<Item> orderedItems = new ArrayList<Item>();
		
		try {
		
			PreparedStatement psmt = con.prepareStatement(sql1);
			psmt.setString(1, orderId);
			
			ResultSet resultSet1 = psmt.executeQuery();
			
			while(resultSet1.next()) {
				
				psmt = con.prepareStatement(sql2);
				psmt.setString(1, resultSet1.getString("itemId"));
				
				ResultSet resultSet2 = psmt.executeQuery();
				
				while(resultSet2.next()) {
					orderedItems.add(getItems(resultSet2));
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return orderedItems;
	}

	private Item getItems(ResultSet resultSet) {
		
		String itemId = null;
		String itemName = null;
		String category = null;
		double rate = 0.0;
		String itemStatus = null;
		
		try {
			
			itemId = resultSet.getString("itemId");
			itemName = resultSet.getString("itemName");
			category = resultSet.getString("category");
			rate = resultSet.getDouble("rate");
			itemStatus = resultSet.getString("itemStatus");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		Item item1 = new Item(itemId, itemName, category, rate, itemStatus);
	
		return item1;
	}
}
