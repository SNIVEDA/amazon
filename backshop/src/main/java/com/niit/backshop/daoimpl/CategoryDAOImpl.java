package com.niit.backshop.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.backshop.dao.CategoryDAO;
import com.niit.backshop.dto.Category;

@Repository("categoryDAO")
@Service
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		String selectActiveCategory = "FROM Category WHERE active= :active";
		Query<Category> query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		query.setParameter("active", true);

		return query.getResultList();
	}

	/*
	 * Get single category based on id
	 * 
	 * @see com.niit.backshop.dao.CategoryDAO#get(int)
	 */
	@Override
	public Category get(int id) {
		// TODO Auto-generated method stub

		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}

	@Override
	public boolean add(Category category) {
		try {
			sessionFactory.getCurrentSession().persist(category);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	/*
	 * Update a single category
	 * 
	 * @see
	 * com.niit.backshop.dao.CategoryDAO#update(com.niit.backshop.
	 * dto.Category)
	 */
	@Override
	public boolean update(Category category) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/*
	 * Delete a single category
	 * 
	 * @see
	 * com.niit.backshop.dao.CategoryDAO#delete(com.niit.backshop.
	 * dto.Category)
	 */
	@Override
	public boolean delete(Category category) {
		// TODO Auto-generated method stub
		category.setActive(false);
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
