package com.niit.backshop.dao;

import java.util.List;

import com.niit.backshop.dto.Supplier;

public interface SupplierDAO {

	Supplier get(int supplierId);

	List<Supplier> list();

	boolean add(Supplier supplier);

	boolean update(Supplier supplier);

	boolean delete(Supplier supplier);
}
