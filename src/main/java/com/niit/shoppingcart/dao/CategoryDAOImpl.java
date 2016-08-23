package com.niit.shoppingcart.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.model.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO  {

	public List<Category> list() {
		
		
		return null;
	}
	@Autowired

	private SessionFactory sessionFactory;

	public CategoryDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	
	}
@Transactional
	public Category get(String id) {
		// TODO Auto-generated method stub
		// sessionFactory.getCurrentSession().get(Category.class,id);
				String hql = "from Category where categoryId=" + "'" + id + "'";
				Query query = sessionFactory.getCurrentSession().createQuery(hql);
				@SuppressWarnings("unchecked")
				List<Category> listCategory = query.list();
				if (listCategory != null && !listCategory.isEmpty()) {
					return listCategory.get(0);
				}
				return null;
	}
	
@Transactional
	public void saveOrUpdate(Category category) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(category);

		
	}
@Transactional
	public void delete(String Id) {
		// TODO Auto-generated method stub
		Category CategoryToDelete = new Category();
		CategoryToDelete.setId(Id);
		sessionFactory.getCurrentSession().delete(CategoryToDelete);
		
	}
@Transactional
	public List<Category> listCategory() {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<Category> listCategory = sessionFactory.getCurrentSession().createCriteria(Category.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listCategory;
		
	}
	
		
}
