package com.briefcase.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;



@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int productId;
	private String productName;
	private String productDescription;
	private String productPhoto;
	private double productPrice;
	private int productdiscount;
	private int productQuantity;
	
	@ManyToOne
	private Category category;
	
	@ManyToOne
	private User user;

	public Product(int productId, String productName, String productDescription, String productPhoto,
			double productPrice, int productdiscount, int productQuantity, Category category, User user) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productDescription = productDescription;
		this.productPhoto = productPhoto;
		this.productPrice = productPrice;
		this.productdiscount = productdiscount;
		this.productQuantity = productQuantity;
		this.category = category;
		this.user = user;
	}
	
	public Product() {
		
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getProductPhoto() {
		return productPhoto;
	}

	public void setProductPhoto(String productPhoto) {
		this.productPhoto = productPhoto;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductdiscount() {
		return productdiscount;
	}

	public void setProductdiscount(int productdiscount) {
		this.productdiscount = productdiscount;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productDescription="
				+ productDescription + ", productPhoto=" + productPhoto + ", productPrice=" + productPrice
				+ ", productdiscount=" + productdiscount + ", productQuantity=" + productQuantity + ", category="
				+ category + ", user=" + user + "]";
	}
	
		
}
