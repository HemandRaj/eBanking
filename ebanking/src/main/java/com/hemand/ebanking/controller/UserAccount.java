package com.hemand.ebanking.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hemand.ebanking.VO.userAccountVO;
import com.hemand.ebanking.VO.userTransferVO;
import com.hemand.ebanking.dao.userDAO;
import com.hemand.ebanking.dao.userTransferDAO;


@WebServlet("/docrate")
public class UserAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		userAccountVO user=new userAccountVO();
		user.accountNumber = request.getParameter("accno");
        user.name = request.getParameter("acname");
        user.gender = request.getParameter("gen");
        user.dob = request.getParameter("dob");
        user.doj = request.getParameter("doj");
        user.address = request.getParameter("add");
        user.mobile = request.getParameter("mob");
        user.email = request.getParameter("email");
        user.accountType = request.getParameter("acctype");
        user.pin= request.getParameter("pin");
        user.bal=request.getParameter("bal");
        
        try {
        	userDAO userDao = new userDAO();
			userDao.addUserDetails(user);
			response.sendRedirect("jsp/success.jsp");
			
		} catch (Exception e) {

			e.printStackTrace();
		}
        String debit="0";
        userTransferVO userTransfer=new userTransferVO();
		userTransfer.setAccountNumber(user.accountNumber);
        userTransfer.setCredit(user.bal);
        userTransfer.setDebit(debit);
        userTransfer.setBal(user.bal);
        userTransfer.setDate(user.doj);
        
        try {
        	userTransferDAO userTransferDao = new userTransferDAO();
			userTransferDao.addUserDetails(userTransfer);
			response.sendRedirect("jsp/success.jsp");
			
		} catch (Exception e) {

			e.printStackTrace();
		}
	
	}

}
