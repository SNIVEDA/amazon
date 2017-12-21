package com.niit.backend.dto;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Address implements Serializable, List<Address> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * private fields
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "user_id")
	private String userId;
	@Column(name = "address_line_one")
	@NotBlank(message = "Please enter address line one!")
	private String addressLineOne;
	@Column(name = "address_line_two")
	@NotBlank(message = "Please enter address line two!")
	private String addressLineTwo;
	@NotBlank(message = "Please enter city name!")
	private String city;
	@NotBlank(message = "Please enter state name!")
    private String state;
	@NotBlank(message = "Please enter Country name!")
    private String country;
	@Column(name = "postal_code")
	@NotBlank(message = "Please enter postal code!")
	private String postalCode;
	private boolean shipping;
	private boolean billing;

	private String contactNumber;

	/*
	 * Setter and getters for the fields
	 */

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserId() {
		return getUserId();

	}

	public void setUserId(String UserId) {
		this.userId = UserId;
	}

	public String getAddressLineOne() {
		return getAddressLineOne();
	}

	public void setAddressLineOne(String addressLineOne) {
		this.addressLineOne = addressLineOne;
	}

	public String getAddressLineTwo() {
		return addressLineTwo;
	}

	public void setAddressLineTwo(String addressLineTwo) {
		this.addressLineTwo = addressLineTwo;
	}

	public String getContactNumber() {
		return getContactNumber();
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCountry() {
		return country;
	}

	public void setPostalCode(String postalcode) {
		this.postalCode = postalcode;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public boolean isShipping() {
		return shipping;
	}

	public void setShipping(boolean shipping) {
		this.shipping = shipping;
	}

	public boolean isBilling() {
		return billing;
	}

	public void setBilling(boolean billing) {
		this.billing = billing;
	}

	@Override
	public boolean add(Address arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void add(int arg0, Address arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean addAll(Collection<? extends Address> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int arg0, Collection<? extends Address> arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Address get(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<Address> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int lastIndexOf(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator<Address> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<Address> listIterator(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Address remove(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Address set(int arg0, Address arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Address> subList(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
  