package com.hemand.ebanking.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hemand.ebanking.VO.employeeAccountVO;
import com.hemand.ebanking.bean.employeeBean;

public class employeeDAO 
{
	public void addUserDetails(employeeAccountVO employeeVO) {
		try {
			Configuration configuration = new Configuration().configure();

			SessionFactory sessionFactory = configuration.buildSessionFactory();

			Session session = sessionFactory.openSession();

			Transaction transaction = session.beginTransaction();
			
			employeeBean employee = new employeeBean();
			
			employee.setEmployeeId(employeeVO.employeeId);
	        employee.setEmployeeName(employeeVO.employeeName);
	        employee.setEmployeeMobile(employeeVO.employeeMobile);
	        employee.setEmployeeEmail(employeeVO.employeeEmail);
	        employee.setEmployeeUsername(employeeVO.employeeUsername);
	        employee.setEmployeePassword(employeeVO.employeePassword);
			
	        session.save(employee);
			transaction.commit();
			
			System.out.println("\n\n Details Added \n");

		} catch (HibernateException e) {
			System.out.println(e.getMessage());
			System.out.println("error");
		}
	}
	
}
