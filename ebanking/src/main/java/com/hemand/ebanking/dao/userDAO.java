package com.hemand.ebanking.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import com.hemand.ebanking.VO.userAccountVO;
import com.hemand.ebanking.bean.userBean;

public class userDAO 
{
	public void addUserDetails(userAccountVO userVO) {
		try {
			Configuration configuration = new Configuration().configure();

			SessionFactory sessionFactory = configuration.buildSessionFactory();

			Session session = sessionFactory.openSession();

			Transaction transaction = session.beginTransaction();
			
			userBean user = new userBean();
			
			user.setAccountNumber(userVO.accountNumber);
	        user.setName(userVO.name);
	        user.setGender(userVO.gender);
	        user.setDob(userVO.dob);
	        user.setDoj(userVO.doj);
	        user.setAddress(userVO.address);
	        user.setMobile(userVO.mobile);
	        user.setEmail(userVO.email);
	        user.setAccountType(userVO.accountType);
	        user.setPin(userVO.pin);
	        user.setBal(userVO.bal);
			
	        session.save(user);
			transaction.commit();
			
			System.out.println("\n\n Details Added \n");

		} catch (HibernateException e) {
			System.out.println(e.getMessage());
			System.out.println("error");
		}
	}
	
	public String retrivePin(String accountnumber) {
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		NativeQuery query = session.createSQLQuery(" SELECT pin from b_acc where acc_no = ?");
		query.setParameter(1, accountnumber);
		List loginDdetails = query.list();
		String pin= loginDdetails.toString();
		return pin;
	}
	
	public String retriveUsername(String accountnumber) {
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		NativeQuery query = session.createSQLQuery(" SELECT uname from user where acc_no = ?");
		query.setParameter(1, accountnumber);
		List loginDdetails = query.list();
		String username= loginDdetails.toString();
		return username;
	}
}
