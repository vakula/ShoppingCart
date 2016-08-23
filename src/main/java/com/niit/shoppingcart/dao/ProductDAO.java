package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.Product;

public interface ProductDAO {
		public List<Product> list();
		
		public Product get(int id);
		
		public  void saveOrUpdate(Product product);
		
		public void delete(int string);
		public List<Product> listProduct();

	}



