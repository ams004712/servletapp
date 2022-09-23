package com.shoppingcart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.shoppingcart.model.Address;
import com.shoppingcart.model.Employee;

public class TestEmployeeRecords {

	public static void main(String[] args) {

		String query = "select e.id empid, e.name empName, e.dob dob, a.id addressId, a.address address, a.state state "
				+ "from employee e, address a where e.id = a.emp_id";

		Connection conn = JdbcConnection.getConnection();

		try {

			PreparedStatement preparedStatement = conn.prepareStatement(query);

			// preparedStatement.se

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
			
			System.out.println(emp);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
