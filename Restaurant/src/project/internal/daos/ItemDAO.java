package project.internal.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project.internal.entity.Item;
import project.internal.ifaces.DAO;
import project.internal.utils.SqlConnection;

public class ItemDAO implements DAO<Item> {

	private Connection con;

	public ItemDAO(Connection con) {
		super();
		this.con = con;
	}

	public ItemDAO() {
		super();
		
		con = SqlConnection.getOracleConnection();
	}

	@Override
	public int add(Item item) {
		String sql = "Insert into Item(itemId,itemName,category,rate,itemStatus) values(?,?,?,?,?)";
		int rowAdded = 0;

		try {

			PreparedStatement pstmt = con.prepareStatement(sql);

			pstmt.setString(1, item.getItemId());
			pstmt.setString(2, item.getItemName());
			pstmt.setString(3, item.getItemCategory());
			pstmt.setDouble(4, item.getItemRate());
			pstmt.setString(5, item.getItemStatus());

			rowAdded = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rowAdded;
	}

	@Override
	public Item find(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Item> findAll() {
		String sql = "Select * from Item";
		List<Item> itemList = new ArrayList<Item>();

		try {

			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				itemList.add(getItems(rs));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return itemList;
	}

	private Item getItems(ResultSet rs) {

		String itemId = null;
		String itemName = null;
		String itemCategory = null;
		double itemRate = 0.0;
		String itemStatus = null;
		try {
			itemName = rs.getString("itemName");
			itemId = rs.getString("itemId");
			itemCategory = rs.getString("category");
			itemRate = rs.getDouble("rate");
			itemStatus = rs.getString("itemStatus");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Item item = new Item(itemId, itemName, itemCategory, itemRate, itemStatus);
		return item;
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

	
}
