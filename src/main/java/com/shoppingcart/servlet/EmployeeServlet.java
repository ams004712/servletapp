package com.shoppingcart.servlet;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shoppingcart.dao.EmployeeDAO;
import com.shoppingcart.model.Address;
import com.shoppingcart.model.Employee;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/Employee")
public class EmployeeServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		EmployeeDAO empDao = new EmployeeDAO();

		Employee employee = empDao.getEmployeeDetail();

		ObjectMapper mapper = new ObjectMapper();

		String employeeData = mapper.writeValueAsString(employee);

		System.out.println("employeeData::" + employeeData);

		req.setAttribute("employee", employeeData);
		RequestDispatcher view = req.getRequestDispatcher("result.jsp");
		view.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String empId = req.getParameter("emp_id");
		String name = req.getParameter("empName");
		String dob = req.getParameter("dob");

		// Address

		String addId = req.getParameter("add_id");
		String address = req.getParameter("address");
		String state = req.getParameter("state");
		String zip = req.getParameter("zip");

		Address add = new Address();
		add.setId(Integer.parseInt(addId));
		add.setAddress(address);
		add.setEmpId(Integer.parseInt(empId));
		add.setState(state);
		add.setZip(Integer.parseInt(zip));

		Employee emp = new Employee();
		emp.setAddresses(List.of(add));
		emp.setDob(dob);
		emp.setId(Integer.parseInt(empId));
		emp.setName(name);

		EmployeeDAO empDao = new EmployeeDAO();
		empDao.createEmployee(emp);

		RequestDispatcher view = req.getRequestDispatcher("result.jsp");
		view.forward(req, resp);

	}
}
