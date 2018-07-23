package com.hemand.ebanking.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hemand.ebanking.VO.userLoginVO;
import com.hemand.ebanking.bean.userLoginBean;

public class userLoginDAO {
	
	public void addUserDetails(userLoginVO userVO) {
		try {
			Configuration configuration = new Configuration().configure();

			SessionFactory sessionFactory = configuration.buildSessionFactory();

			Session session = sessionFactory.openSession();

			Transaction transaction = session.beginTransaction();
			
			userLoginBean user = new userLoginBean();
			
			user.setUsername(userVO.username);
	        user.setPassword(userVO.password);
	        user.setType(userVO.type);
	        
	        session.save(user);
			transaction.commit();
			
			System.out.println("\n\n Details Added \n");

		} catch (HibernateException e) {
			System.out.println(e.getMessage());
			System.out.println("error");
		}
	}

}
