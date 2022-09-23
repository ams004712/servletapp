package com.shoppingcart.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shoppingcart.model.Address;
import com.shoppingcart.model.Employee;

public class EmployeeDAO {

	private static final String query = "select e.id empid, e.name empName, e.dob dob, a.id addressId, a.address address, a.state state "
			+ "from employee e, address a where e.id = a.emp_id";
	
	private static final String EMP_INSERT_QUERY = "INSERT INTO EMPLOYEE (id, name, dob) VALUES (?,?,?)";
	
	private static final String ADD_INSERT_QUERY = "INSERT INTO ADDRESS (id, emp_id, address, state, zip_code) VALUES (?,?,?,?,?)";

	public Employee getEmployeeDetail() {

		try {

			PreparedStatement preparedStatement = JdbcConnection.getConnection().prepareStatement(query);

			ResultSet resultSet = preparedStatement.executeQuery();

			Employee emp = null;

			List<Address> addresses = new ArrayList<>();

			Address address = null;

			while (resultSet.next()) {

				Integer empId = resultSet.getInt("empid");
				String name = resultSet.getString("empName");
				String dob = resultSet.getString("dob");
				Integer addressId = resultSet.getInt("addressId");
				String empAddress = resultSet.getString("address");
				String state = resultSet.getString("state");

				if (emp == null) {
					emp = new Employee();
					emp.setId(empId);
					emp.setName(name);
					emp.setDob(dob);

				}

				address = new Address();
				address.setId(addressId);
				address.setAddress(empAddress);
				address.setState(state);
				addresses.add(address);

			}
			emp.setAddresses(addresses);

			return emp;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void createEmployee(Employee emp) {
		
		try {
			PreparedStatement empPS = JdbcConnection.getConnection().prepareStatement(EMP_INSERT_QUERY);
			
			empPS.setInt(1, emp.getId());
			empPS.setString(2, emp.getName());
			empPS.setString(3, emp.getDob());
			
			empPS.executeUpdate();
			
			PreparedStatement addPS = JdbcConnection.getConnection().prepareStatement(ADD_INSERT_QUERY);
			
			addPS.setInt(1, emp.getAddresses().get(0).getId());
			addPS.setInt(2, emp.getAddresses().get(0).getEmpId());
			addPS.setString(3, emp.getAddresses().get(0).getAddress());
			addPS.setString(4, emp.getAddresses().get(0).getState());
			addPS.setInt(5, emp.getAddresses().get(0).getZip());
			
			addPS.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
}
