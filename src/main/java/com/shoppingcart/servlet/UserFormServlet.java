package com.shoppingcart.servlet;

import java.io.IOException;
import java.sql.Connection;

import com.shoppingcart.dao.JdbcConnection;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/*@WebServlet(
        name = "selectliquorservlet",
        urlPatterns = "/SelectJuice"
)*/
//@WebServlet("/SelectJuice")
@WebServlet(urlPatterns = "/UserForm")
public class UserFormServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userName = req.getParameter("userName");
        
        String dob = req.getParameter("dob");

        System.out.println("userName:::"+userName);
        System.out.println("dob:::"+dob);
        
        
        Connection con = JdbcConnection.getConnection();
        
        System.out.println("Connection:"+con);

        req.setAttribute("userName", userName);
        req.setAttribute("dob", dob);
        RequestDispatcher view = req.getRequestDispatcher("result.jsp");
        view.forward(req, resp);

    }
}
