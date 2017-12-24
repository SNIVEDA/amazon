package com.niit.backshop.dao;

import java.util.List;

import com.niit.backshop.dto.Category;

public interface CategoryDAO {

	// get single category based on id
	Category get(int id);

	// get all categories
	List<Category> list();

	// adding a new category
	boolean add(Category category);

	// updating a category
	boolean update(Category category);

	// deleting a category
	boolean delete(Category category);

}
