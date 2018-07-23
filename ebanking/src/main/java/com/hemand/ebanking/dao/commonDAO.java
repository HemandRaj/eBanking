package com.hemand.ebanking.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import com.hemand.ebanking.bean.employeeBean;
import com.hemand.ebanking.bean.userBean;

public class commonDAO 
{
	public String retrivePassword(String username) {
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		NativeQuery query = session.createSQLQuery(" SELECT pass from login where name = ?");
		query.setParameter(1, username);
		List loginDdetails = query.list();
		String password= loginDdetails.get(0).toString();
		return password;
	}
	
	public String retriveUsertype(String username) {
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		NativeQuery query = session.createSQLQuery(" SELECT type from login where name = ?");
		query.setParameter(1, username);
		List loginDdetails = query.list();
		String usertype= loginDdetails.get(0).toString();
		return usertype;
	}
	
	public String retriveEmployeeId(String username) {
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		NativeQuery query = session.createSQLQuery(" SELECT empid from emp_id where username = ?");
		query.setParameter(1, username);
		List loginDdetails = query.list();
		String empId= loginDdetails.get(0).toString();
		return empId;
	}
	
	public static userBean retriveUser(String username) {
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		NativeQuery query = session.createSQLQuery(" SELECT uname from user where name = ?");
		query.setParameter(1, username);
		List loginDdetails = query.list();
		String accountNumber=loginDdetails.get(0).toString();
		NativeQuery queryOne= session.createSQLQuery(" SELECT * from b_acc where acc_no = ?").addEntity(employeeBean.class);
		queryOne.setParameter(1, accountNumber);
		List<userBean> employeeDetails=(List<userBean>)queryOne.list();
		return (userBean)employeeDetails;
	}

}