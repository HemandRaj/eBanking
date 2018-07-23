package com.hemand.ebanking.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hemand.ebanking.VO.userEbankingVO;
import com.hemand.ebanking.VO.userLoginVO;
import com.hemand.ebanking.dao.commonDAO;
import com.hemand.ebanking.dao.userEbankDAO;
import com.hemand.ebanking.dao.userLoginDAO;


@WebServlet("/userebank")
public class UserEBanking extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserEBanking() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		userEbankingVO user=new userEbankingVO();
		user.username = request.getParameter("username");
    	user.password = request.getParameter("cpassword");
    	user.accountNumber = request.getParameter("account");
    	user.pin = request.getParameter("pin");
    	
    	try {
        	userEbankDAO userDao = new userEbankDAO();
			userDao.usercheck(user);
			response.sendRedirect("jsp/success.jsp");
		} catch (Exception e) {

			e.printStackTrace();
		}
    	
    	String userType="User";
    	
    	userLoginVO userLogin=new userLoginVO();
		userLogin.setUsername(user.username);
    	userLogin.setPassword(user.password);
    	userLogin.setType(userType);
    	
    	try {
        	userLoginDAO userLoginDao = new userLoginDAO();
			userLoginDao.addUserDetails(userLogin);
			response.sendRedirect("jsp/success.jsp");
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
