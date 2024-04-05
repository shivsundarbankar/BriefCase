package com.briefcase.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(length=10, name="user_id")
	private int userId;
	
	@Column(length=100, name="user_name")
	private String userName;
	
	@Column(length=50, name="user_email")
	private String userEmail;
	
	@Column(length=50, name="user_password")
	private String userPassword;
	
	@Column(length=12, name="user_phone")
	private String userPhone;
	
	@Column(length=1500,name="user_pic")
	private String userPicture;
	
	@Column(length=1500,name="userAddress")
	private String userAddress;
	
	@Column(name="role")
	private String role;
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="user", cascade=CascadeType.ALL)
	private List<Product> product = new ArrayList<>();

	public User(String userName, String userEmail, String userPassword, String userPhone,
			String userPicture, String userAddress, String role, List<Product> product) {
		super();
		
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userPhone = userPhone;
		this.userPicture = userPicture;
		this.userAddress = userAddress;
		this.role=role;
		this.product = product;
	}
	
	public User() {
		
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserPicture() {
		return userPicture;
	}

	public void setUserPicture(String userPicture) {
		this.userPicture = userPicture;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail + ", userPassword="
				+ userPassword + ", userPhone=" + userPhone + ", userPicture=" + userPicture + ", userAddress="
				+ userAddress + ", role=" + role + ", product=" + product + "]";
	}
	
	

	
	
	
}
