package com.hemand.ebanking.controller;



import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hemand.ebanking.dao.commonDAO;


@WebServlet("/doLogin")
public class doLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String textInputUsername = request.getParameter("username");
		String textInputpassword = request.getParameter("password");
		String option=request.getParameter("op");
		String password = new commonDAO().retrivePassword(textInputUsername);
		String userAccountType = new commonDAO().retriveUsertype(textInputUsername);
		HttpSession session=request.getSession();
				
				if(textInputpassword.equals(password))
				{
					if((option.equals("User"))&&(userAccountType.equals("User")))
					{
						session.setAttribute("uname", textInputUsername);
						RequestDispatcher rd =request.getRequestDispatcher("jsp/welu.jsp");
						rd.forward(request,response);
				    }
					else if((option.equals("Employee"))&&(userAccountType.equals("Employee")))
					{
						session.setAttribute("uname", textInputUsername);
						RequestDispatcher rd =request.getRequestDispatcher("jsp/wele.jsp");
						rd.forward(request,response);
				    }
					else if((option.equals("Admin"))&&(userAccountType.equals("Admin")))
					{
							session.setAttribute("uname", textInputUsername);
							RequestDispatcher rd =request.getRequestDispatcher("jsp/welad.jsp");
							rd.forward(request,response);
					}
					else
					{
			         RequestDispatcher rd =request.getRequestDispatcher("jsp/fail.html");
						rd.forward(request,response);
					}
					}
				else
				{
					System.out.print("enetr");
		         RequestDispatcher rd =request.getRequestDispatcher("jsp/fail.html");
					rd.forward(request,response);
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
