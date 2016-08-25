package com.niit.shoppingcart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Table(name="User")
@Component
public class Login {
	
	@Id
	@Column(name="Id")
	private int Id;
	
	private String username;
	private String password;
	private double Mobile;
	private String Role="ROLE_ADMIN";
	private boolean Status;
	@Id
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getMobile() {
		return Mobile;
	}
	public void setMobile(double mobile) {
		Mobile = mobile;
	}
	public String getRole() {
		return Role;
	}
	public void setRole(String role) {
		Role = role;
	}
	public boolean isStatus() {
		return Status;
	}
	public void setStatus(boolean status) {
		Status = status;
	}
	void setEmail(String string) {
		// TODO Auto-generated method stub
		
	}
	public Login get(int id2) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	



	


}
