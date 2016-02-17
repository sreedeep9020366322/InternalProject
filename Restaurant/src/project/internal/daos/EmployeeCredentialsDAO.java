package project.internal.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import project.internal.entity.EmployeeCredentials;
import project.internal.ifaces.DAO;
import project.internal.utils.SqlConnection;

public class EmployeeCredentialsDAO implements DAO<EmployeeCredentials> {

	private Connection con= null;
	
	
	public EmployeeCredentialsDAO(Connection con) {
		super();
		this.con = con;
	}

	
	public EmployeeCredentialsDAO() {
		super();
		
		con = SqlConnection.getOracleConnection();
	}


	@Override
	public int add(EmployeeCredentials t) {
		
		String sql = "insert into EmployeeCredentials values(?,?)";
		int rowAdded = 0;
		
		try {
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, t.getEmployeeId());
			pstmt.setString(2, t.getEmployeePswd());
			
			rowAdded = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowAdded;

	}

	@Override
	public EmployeeCredentials find(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeCredentials> findAll() {
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
