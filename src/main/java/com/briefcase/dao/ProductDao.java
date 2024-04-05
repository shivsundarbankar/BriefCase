package com.briefcase.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.briefcase.entities.Product;

public class ProductDao {
	private SessionFactory factory;

	public ProductDao(SessionFactory factory) {
		super();
		this.factory = factory;
	}
	
	@SuppressWarnings("deprecation")
	public boolean saveProduct(Product product) {
		boolean f = false;
		try{
			Session session = factory.openSession();
			Transaction tx = session.beginTransaction();
			session.save(product);
			tx.commit();
			session.close();
			f=true;
			
		}catch(Exception e) {
			
		}
		return f;
	}
}
