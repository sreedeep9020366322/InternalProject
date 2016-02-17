package project.internal.apps;

//import java.sql.Date;

import project.internal.daos.EmployeeCredentialsDAO;
import project.internal.daos.EmployeeDAO;
import project.internal.domains.ValidateUser;
import project.internal.entity.Employee;
import project.internal.entity.EmployeeCredentials;
import project.internal.entity.OrderItem;
//import project.internal.utils.SqlConnection;

public class RestaurantApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// System.out.println(SqlConnection.getOracleConnection());

		Employee employee1 = new Employee("Sreedeep", "M101", "Manager", "32B", 9874562,
				java.sql.Date.valueOf("2010-02-13"));

		EmployeeDAO dao = new EmployeeDAO();

		// dao.add(employee1);

		// OrderItem order1 = new OrderItem("L101", "VG102", 3, "Make it fast",
		// "pending");

		// System.out.println(dao.addOrderItems(order1));

		// EmployeeCredentials ecredentials = new EmployeeCredentials("M101",
		// "sree");

		// EmployeeCredentialsDAO daoCredentials = new EmployeeCredentialsDAO();

		// daoCredentials.add(ecredentials);

		// ValidateUser validate = new ValidateUser();
		// System.out.println(validate.validate(ecredentials));

	}

}
