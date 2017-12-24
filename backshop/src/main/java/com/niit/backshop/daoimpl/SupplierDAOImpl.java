package com.niit.backshop.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.backshop.dao.SupplierDAO;
import com.niit.backshop.dto.Supplier;

@Repository("supplierDAO")
@Transactional
public class SupplierDAOImpl implements SupplierDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Supplier get(int supplierId) {
		try {
			return sessionFactory.getCurrentSession().get(Supplier.class, Integer.valueOf(supplierId));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Supplier> list() {
		return sessionFactory.getCurrentSession().createQuery("FROM Supplier", Supplier.class).getResultList();
	}

	@Override
	public boolean add(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().persist(supplier);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().update(supplier);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Supplier supplier) {
		try {

			supplier.setActive(false);
			// call the update method
			return this.update(supplier);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

}
