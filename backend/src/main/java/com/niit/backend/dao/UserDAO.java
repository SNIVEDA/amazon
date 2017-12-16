package com.niit.backend.dao;

import java.util.List;

import com.niit.backend.dto.Address;
import com.niit.backend.dto.Cart;
import com.niit.backend.dto.User;

public interface UserDAO {

	// add a user
	boolean addUser(User user);
	User getByEmail(String email);
	
	// add an address
	boolean addAddress(Address address);
	//alternative
	Address getBillingAddress(int userId);
	List<Address> listShippingAddress(int userId);
	
	/*
	 * Address getBillingAddress(User user); 
	 * List<Address> listShippingAddresses(User user);
	 *  */
	 
	// update a cart
	boolean addCart(Cart cart);
	List<Address> listShippingAddresses(int userId);

}
