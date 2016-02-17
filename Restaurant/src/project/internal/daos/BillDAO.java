package project.internal.daos;

import java.sql.Connection;
import java.util.List;

import project.internal.entity.Bill;
import project.internal.ifaces.DAO;
import project.internal.utils.SqlConnection;

public class BillDAO implements DAO<Bill> {

	private Connection con;

	public BillDAO(Connection con) {
		super();
		this.con = con;
	}

	public BillDAO() {

		super();
		con = SqlConnection.getOracleConnection();

	}

	@Override
	public int add(Bill t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Bill find(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Bill> findAll() {
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
