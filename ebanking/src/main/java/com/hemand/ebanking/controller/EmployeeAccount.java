package com.hemand.ebanking.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hemand.ebanking.VO.employeeAccountVO;
import com.hemand.ebanking.VO.employeeLoginVO;
import com.hemand.ebanking.dao.employeeDAO;
import com.hemand.ebanking.dao.employeeLoginDAO;

@WebServlet("/empacc")
public class EmployeeAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public EmployeeAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		employeeAccountVO employee=new employeeAccountVO();
		
		employee.employeeId=request.getParameter("empid");
	    employee.employeeName=request.getParameter("empnam");
	    employee.employeeMobile=request.getParameter("emplmob");
	    employee.employeeEmail=request.getParameter("emplem");
	    employee.employeeUsername=request.getParameter("emplnus");
	    employee.employeePassword=request.getParameter("emplpas");
	    
	    try {
        	employeeDAO employeeDao = new employeeDAO();
			employeeDao.addUserDetails(employee);
			response.sendRedirect("jsp/welad.jsp");
		} catch (Exception e) {

			e.printStackTrace();
		}
	
	    String employeeType="Employee";
	    
        employeeLoginVO employeeLogin=new employeeLoginVO();
		
		employeeLogin.setUsername(employee.employeeUsername);
	    employeeLogin.setPassword(employee.employeePassword);
	    employeeLogin.setType(employeeType);
	    
	    try {
        	employeeLoginDAO employeeLoginDao = new employeeLoginDAO();
			employeeLoginDao.addUserDetails(employeeLogin);
			response.sendRedirect("jsp/welad.jsp");
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
