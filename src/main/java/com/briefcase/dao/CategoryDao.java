package com.briefcase.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.briefcase.entities.Category;


public class CategoryDao {
	
	private SessionFactory factory;

	public CategoryDao(SessionFactory factory) {
		super();
		this.factory = factory;
	}
	
	public int saveCategory(Category category) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		int categoryId = (int) session.save(category);
		tx.commit();
		session.close();
		return categoryId;
		
	}
	
	public List<Category> getCategories(){
		Session session = factory.openSession();
		Query query = session.createQuery("from Category");
		List<Category> list = query.list();
		return list;
	}
	
	public Category getCategory(int categoryId) {
		Category category = null;
		try {
			Session session = factory.openSession();
			category = session.get(Category.class, categoryId);
			session.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return category;
		
	}
	

}
