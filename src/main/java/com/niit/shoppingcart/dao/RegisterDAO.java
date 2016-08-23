package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.Register;

public interface RegisterDAO {
		public List<Register> list();
		
		public Register get(int id);
		
		public void saveOrUpdate(Register user);
		
		public void delete(int id);
		public List<Register> listRegister();
		public boolean isValidUser(int id, String name);
	}



