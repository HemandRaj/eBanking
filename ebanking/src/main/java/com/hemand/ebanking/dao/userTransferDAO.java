package com.hemand.ebanking.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hemand.ebanking.VO.userTransferVO;
import com.hemand.ebanking.bean.userTransferBean;

public class userTransferDAO {
	
	public void addUserDetails(userTransferVO userVO) {
		try {
			Configuration configuration = new Configuration().configure();

			SessionFactory sessionFactory = configuration.buildSessionFactory();

			Session session = sessionFactory.openSession();

			Transaction transaction = session.beginTransaction();
			
			userTransferBean user = new userTransferBean();
			
			user.setAccountNumber(userVO.accountNumber);
	        user.setCredit(userVO.credit);
	        user.setDebit(userVO.debit);
	        user.setBal(userVO.bal);
	        user.setDate(userVO.date);
			
	        session.save(user);
			transaction.commit();
			
			System.out.println("\n\n Details Added \n");

		} catch (HibernateException e) {
			System.out.println(e.getMessage());
			System.out.println("error");
		}
	}

}
