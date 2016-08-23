package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.Login;
import com.niit.shoppingcart.model.Register;

public interface LoginDAO {
		public List<Login> list();
		
		public Login get(int id);
		
		public void save(Login user);
		public void Update(Login user);
		
		public void delete(int string);
		public List<Login> listUser();
	
	}



