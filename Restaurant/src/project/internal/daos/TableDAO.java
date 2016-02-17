package project.internal.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import project.internal.entity.Table;
import project.internal.ifaces.DAO;
import project.internal.utils.SqlConnection;

public class TableDAO implements DAO<Table> {

	private Connection con;

	public TableDAO() {
		super();
		con = SqlConnection.getOracleConnection();

	}

	public TableDAO(Connection con) {
		super();
		this.con = con;
	}

	@Override
	public int add(Table table) {
		String sql = "Insert into TableInfo(tableId,employeeId) values(?,?)";
		int rowAdded = 0;

		try {

			PreparedStatement pstmt = con.prepareStatement(sql);

			pstmt.setString(1, table.getTableId());
			pstmt.setString(2, table.getEmployeeId());

			rowAdded = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rowAdded;

	}

	@Override
	public Table find(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Table> findAll() {
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

}
