package com.niit.shoppingcart.dao;

import java.util.List;

import org.hibernate.Criteria;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.model.Supplier;

@Repository("supplierDAO")
public class SupplierDAOImpl implements SupplierDAO  {

	@Autowired
	private SessionFactory sessionFactory;

	public SupplierDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	
	}
@Transactional
	public Supplier get(String id) {
		// TODO Auto-generated method stub
		// sessionFactory.getCurrentSession().get(Supplier.class,id);
				String hql = "from Supplier where supplierId=" + "'" + id + "'";
				Query query = sessionFactory.getCurrentSession().createQuery(hql);
				@SuppressWarnings("unchecked")
				List<Supplier> listSupplier = query.list();
				if (listSupplier != null && !listSupplier.isEmpty()) {
					return listSupplier.get(0);
				}
				return null;
	}
	
@Transactional
	public void saveOrUpdate(Supplier supplier) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(supplier);

		
	}
@Transactional
	public void delete(String Id) {
		// TODO Auto-generated method stub
		Supplier SupplierToDelete = new Supplier();
		SupplierToDelete.setId(Id);
		sessionFactory.getCurrentSession().delete(SupplierToDelete);
		
	}
@Transactional
	public List<Supplier> listSupplier() {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<Supplier> listSupplier = sessionFactory.getCurrentSession().createCriteria(Supplier.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listSupplier;
		
	}
	
		
}
