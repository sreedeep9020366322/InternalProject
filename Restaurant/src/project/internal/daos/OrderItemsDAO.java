package project.internal.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import project.internal.entity.OrderItem;
import project.internal.ifaces.DAO;
import project.internal.utils.SqlConnection;

public class OrderItemsDAO implements DAO<OrderItem> {
	
	private Connection con;

	
	public OrderItemsDAO() {
		super();
		con = SqlConnection.getOracleConnection();
	}

	public OrderItemsDAO(Connection con) {
		super();
		this.con = con;
	}

	@Override
	public int add(OrderItem order) {
		String sql = "Insert into order_Item(orderId,itemId,quantity,orderComment,orderStatus,amount) values(?,?,?,?,?,?)";
		int rowAdded = 0;
		
		try {
		
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, order.getOrderId());
			pstmt.setString(2, order.getItemId());
			pstmt.setLong(3, order.getQuantity());
			pstmt.setString(4, order.getOrderComment());
			pstmt.setString(5, order.getOrderStatus());
			pstmt.setDouble(6, order.getAmount());
			
			
			rowAdded = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return rowAdded;

	}

	@Override
	public OrderItem find(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderItem> findAll() {
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
	

	public double findAmount(String itemId) {
		
		String sql = "select rate from Item where itemId = ?";
		double amount = 0.0;
		
		try {
			
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setString(1, itemId);
			ResultSet resultSet = psmt.executeQuery();
			
			if(resultSet.next())
				amount = resultSet.getDouble("rate");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return amount; 
	 }
}
