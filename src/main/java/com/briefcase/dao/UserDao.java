package com.briefcase.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.briefcase.entities.User;


public class UserDao {
	private SessionFactory factory;

	public UserDao(SessionFactory factory) {
		super();
		this.factory = factory;
	}
	
	//get user by email by password
	
	public User getUserByEmailAndPassword(String email, String password ) {
		User user = null;
		
		try {
			String query = "from User where userEmail =: e and userPassword =: p";
			Session session = this.factory.openSession();
			Query q = session.createQuery(query);
			q.setParameter("e", email);
			q.setParameter("p", password);
			
			user = (User)q.uniqueResult();
			session.close();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return user;
	}
	
	@SuppressWarnings("deprecation")
	public User getUserById(int userId) {
		User user = null;
		try {
			String query ="from User where userId =: u";
			Session session = factory.openSession();
			Query q = session.createQuery(query);
			q.setParameter("u", userId);
			user = (User)q.uniqueResult();
			session.close();
		}catch(Exception e) {
			
		}
		return user;
	}
	
	
	
}
