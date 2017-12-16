package com.niit.frontend.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.niit.backend.dao.UserDAO;
import com.niit.backend.dto.Address;
import com.niit.backend.dto.Cart;
import com.niit.backend.dto.User;
import com.niit.frontend.model.RegisterModel;

@Component
public class RegisterHandler {

	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public RegisterModel init() {
		
		return new RegisterModel();
		
	}
	
	
	public void addUser(RegisterModel registerModel, User user) {		
		registerModel.setUser(user);
	}
	
	public void addBilling(RegisterModel registerModel, Address billing) {		
		registerModel.setBilling(billing);
	}
		
	
	public String validateUser(User user, MessageContext error)  {
		
		String transitionValue = "success";
		
		// checking if password matches confirm password
		
		if(!(user.getConfirmPassword().equals(user.getConfirmPassword()))) {
			
			error.addMessage(new MessageBuilder()
						.error()
						.source("confirmPassword")
						.defaultText("Password does not match the confirm password!")
						.build()
						);
			
			
			transitionValue = "failure";
			
		}
			
		// check the uniqueness of the email id
		
		if(userDAO.getByEmail(user.getEmail())!=null) {
			
			error.addMessage(new MessageBuilder()
					.error()
					.source("email")
					.defaultText("Email address is already used!")
					.build()
					);
		
			
			transitionValue = "failure";
			
		}
		
		
		
		return transitionValue;
		
	}
	
	
	
	public String saveAll(RegisterModel model) {
		String transitionValue = "success";
		
		
		// fetch the user
		User user = model.getUser();
		
		if(user.getRole().equals("USER")) {			
			Cart cart = new Cart();			
			cart.setUserId(user);			
			user.setCart(cart);			
		}
		
		
		// encode the password
		user.setPassword(passwordEncoder.encode(user.getConfirmPassword()));
		
		
		// save the user
		
		userDAO.addUser(user);
		
		
		// get the address
		
		Address billing = model.getBilling();
		billing.setId(user.getId());
		billing.setBilling(true);

		// save the address
		userDAO.addAddress(billing);		
		
		return transitionValue;
		
	}
	
	
	
	
	
	
}
