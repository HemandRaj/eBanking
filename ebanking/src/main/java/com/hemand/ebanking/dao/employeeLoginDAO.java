package com.hemand.ebanking.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hemand.ebanking.VO.employeeLoginVO;
import com.hemand.ebanking.bean.employeeLoginBean;

public class employeeLoginDAO {
	
	public void addUserDetails(employeeLoginVO employeeVO) {
		try {
			Configuration configuration = new Configuration().configure();

			SessionFactory sessionFactory = configuration.buildSessionFactory();

			Session session = sessionFactory.openSession();

			Transaction transaction = session.beginTransaction();
			
			employeeLoginBean employee = new employeeLoginBean();
			
			employee.setUsername(employeeVO.username);
			employee.setPassword(employeeVO.password);
			employee.setType(employeeVO.type);
	        
	        session.save(employee);
			transaction.commit();
			
			System.out.println("\n\n Details Added \n");

		} catch (HibernateException e) {
			System.out.println(e.getMessage());
			System.out.println("error");
		}
	}

}
