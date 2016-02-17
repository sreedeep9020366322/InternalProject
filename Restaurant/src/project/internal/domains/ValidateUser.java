package project.internal.domains;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import project.internal.entity.EmployeeCredentials;
import project.internal.utils.SqlConnection;

public class ValidateUser {

	public boolean validate(EmployeeCredentials user) {

		final Connection con = SqlConnection.getOracleConnection();
		boolean result = false;
		try {
			String sql = "Select * from EmployeeCredentials where EmployeeId = ? and EmployeePswd = ?";

			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getEmployeeId());
			pstmt.setString(2, user.getEmployeePswd());
			final ResultSet resultset = pstmt.executeQuery();

			if (resultset.next())
				result = true;
			else
				result = false;

		} catch (Exception e) {

			e.printStackTrace();
		}

		return result;
	}
}
