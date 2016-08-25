package com.niit.shoppingcart.dao;

import java.util.List;

import org.hibernate.Criteria;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.model.Register;


@Repository("registerDAO")
public class RegisterDAOImpl implements RegisterDAO 
{

	public List<Register> list() {
		
		
		return null;
	}
	@Autowired

	private SessionFactory sessionFactory;

	public RegisterDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	
	}
@Transactional
	public Register get(int id) {
		// TODO Auto-generated method stub
		// sessionFactory.getCurrentSession().get(User.class,id);
				String hql = "from UserDetails where userId=" + "'" + id + "'";
				Query query = sessionFactory.getCurrentSession().createQuery(hql);
				@SuppressWarnings("unchecked")
				List<Register> listUserDetails = query.list();
				if (listUserDetails != null && !listUserDetails.isEmpty()) {
					return listUserDetails.get(0);
				}
				return null;
	}
	
@Transactional
	public void saveOrUpdate(Register user)
{
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(user);

		
	}
@Transactional
	public void delete(int Id) {
		// TODO Auto-generated method stub
		Register UserDetailsToDelete = new Register();
		UserDetailsToDelete.setId(Id);
		sessionFactory.getCurrentSession().delete(UserDetailsToDelete);
		
	}
@Transactional
	public List<Register> listUserDetails() {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<Register> listUserDetails = sessionFactory.getCurrentSession().createCriteria(Register.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listUserDetails;
		
	}
@Transactional
public void save(Register user)
{
	sessionFactory.getCurrentSession().saveOrUpdate(user);	
	
}
public List<Register> listRegister() {
	// TODO Auto-generated method stub
	return null;
}
public boolean isValidUser(int id, String name) {
	// TODO Auto-generated method stub
	return false;
}		
}
