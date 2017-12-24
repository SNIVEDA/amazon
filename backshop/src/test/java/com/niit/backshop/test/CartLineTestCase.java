package com.niit.backshop.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.backshop.dao.CartLineDAO;
import com.niit.backshop.dao.ProductDAO;
import com.niit.backshop.dao.UserDAO;
import com.niit.backshop.dto.Cart;
import com.niit.backshop.dto.CartLine;
import com.niit.backshop.dto.Product;
import com.niit.backshop.dto.User;

public class CartLineTestCase {

	private static AnnotationConfigApplicationContext context;

	private static CartLineDAO cartLineDAO;
	private static ProductDAO productDAO;
	private static UserDAO userDAO;

	private CartLine cartLine = null;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.backshop");
		context.refresh();
		cartLineDAO = (CartLineDAO) context.getBean("cartLineDAO");
		productDAO = (ProductDAO) context.getBean("productDAO");
		userDAO = (UserDAO) context.getBean("userDAO");
	}

	@Test
	public void testAddCartLine() {

		// fetch the user and then cart of that user
		User user = userDAO.getByEmail("sudha@gmail.com");
		Cart cart = user.getCart();

		// fetch the product
		Product product = productDAO.get(2);

		// Create a new CartLine
		cartLine = new CartLine();

		cartLine.setBuyingPrice(product.getUnitPrice());
		cartLine.setProductCount(cartLine.getProductCount() + 1);
		cartLine.setTotal(cartLine.getProductCount() * product.getUnitPrice());
		cartLine.setAvailable(true);
		cartLine.setCartId(1);
		cartLine.setProduct(product);
		/*
		 * cartLine.setCartId(cart.getId()); cartLine.setProduct(product);
		 * cartLine.setProductCount(1);
		 */
		/*
		 * double oldTotal = cartLine.getTotal();
		 * 
		 * cartLine.setTotal(product.getUnitPrice() * cartLine.getProductCount());
		 * 
		 * cart.setCartLines(cart.getCartLines() + 1);
		 * cart.setGrandTotal(cart.getGrandTotal() + (cartLine.getTotal() - oldTotal));
		 */
		assertEquals("Failed to add the CartLine!", true, cartLineDAO.add(cartLine));
		//
		// cart.setGrandTotal(cart.getGrandTotal() + cartLine.getTotal());
		// cart.setCartLines(cart.getCartLines() + 1);

		// assertEquals("Failed to update the cart!", true,
		// cartLineDAO.updateCart(cart));

	}

}
