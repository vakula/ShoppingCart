
package com.niit.shoppingcart.dao;

import java.util.List;

import org.hibernate.Criteria;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.model.Login;
import com.niit.shoppingcart.model.Register;

@Repository("userDAO")
public class LoginDAOImpl implements LoginDAO 
{

	public List<Login> list() {
		
		
		return null;
	}
	@Autowired

	private SessionFactory sessionFactory;

	public LoginDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	
	}
@Transactional
	public Login get(int id) {
		// TODO Auto-generated method stub
		// sessionFactory.getCurrentSession().get(User.class,id);
				String hql = "from User where userId=" + "'" + id + "'";
				Query query = sessionFactory.getCurrentSession().createQuery(hql);
				@SuppressWarnings("unchecked")
				List<Login> listUser = query.list();
				if (listUser != null && !listUser.isEmpty()) {
					return listUser.get(0);
				}
				return null;
	}
	
@Transactional
	public void save(Login user)
{
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(user);

		
	}
@Transactional
public void update(Login user)
{
	// TODO Auto-generated method stub
	sessionFactory.getCurrentSession().update(user);

	
}
@Transactional
	public void delete(int Id) {
		// TODO Auto-generated method stub
		Login UserToDelete = new Login();
		UserToDelete.setId(Id);
		sessionFactory.getCurrentSession().delete(UserToDelete);
		
	}
@Transactional
	public List<Login> listUser() {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<Login> listUser = sessionFactory.getCurrentSession().createCriteria(Login.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listUser;
		
	}
		
}
