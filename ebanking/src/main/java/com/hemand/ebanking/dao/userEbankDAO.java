package com.hemand.ebanking.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hemand.ebanking.VO.userEbankingVO;
import com.hemand.ebanking.bean.userEbankingBean;

public class userEbankDAO 
{
	public void usercheck(userEbankingVO userVO)
	{
		userEbankingBean user = new userEbankingBean();
		user.setUsername(userVO.username);
        user.setPassword(userVO.password);
        user.setAccountNumber(userVO.accountNumber);
        user.setPin(userVO.pin);
		
        String pin = new userDAO().retrivePin(user.accountNumber);
        
			if(pin.equals(user.pin))
			{
				String uname= new userDAO().retriveUsername(user.accountNumber);
					if(uname.equals(user.username))
						{	
						    System.out.println("Duplicate Entry");	
						}
					else
						{
						    addUserDetails(user);									
						}				
        	}
			else
			{	
				System.out.println("Check your account number and pin correctly");
			} 	
	}	

	void addUserDetails(userEbankingBean user) {
		try {
			Configuration configuration = new Configuration().configure();

			SessionFactory sessionFactory = configuration.buildSessionFactory();

			Session session = sessionFactory.openSession();

			Transaction transaction = session.beginTransaction();
			
			session.save(user);
			
			transaction.commit();
			
			System.out.println("\n\n Details Added \n");

		} catch (HibernateException e) {
			
			System.out.println(e.getMessage());
			
			System.out.println("error");
		}

	}
}