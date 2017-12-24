package com.niit.backshop.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.backshop.dao.ProductDAO;
import com.niit.backshop.dto.Product;

public class ProductTestCase {

	private static AnnotationConfigApplicationContext context;

	private static ProductDAO productDAO;

	private Product product;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.backshop");
		context.refresh();
		productDAO = (ProductDAO) context.getBean("productDAO");
	}

	// @Test
	// public void testCRUDProduct() {
	//
	// // create operation
	// product = new Product();
	//
	// product.setName("Hoodie");
	// product.setBrand("Puma");
	// product.setDescription("A hoodie is a sweatshirt with a hood.");
	// product.setUnitPrice(2500);
	// product.setActive(true);
	// product.setCategoryId(5);
	// product.setSupplierId(3);
	//
	// assertEquals("Bug :(",
	// true,productDAO.add(product));
	//
	//
	// // reading and updating the category
	// product = productDAO.get(1);
	// product.setName("Black Dress");
	// assertEquals("Bug :(",
	// true,productDAO.update(product));
	//
	// assertEquals("Bug :(",
	// true,productDAO.delete(product));
	//
	// // list
	// assertEquals("Bug :(",
	// 6,productDAO.list().size());
	//
	// }
	//

	// @Test
	// public void testListActiveProducts() {
	// assertEquals("Bug :(",
	// 5,productDAO.listActiveProducts().size());
	// }
	//

	// @Test
	// public void testListActiveProductsByCategory() {
	// assertEquals("Bug :(",
	// 2,productDAO.listActiveProductsByCategory(2).size());
	// assertEquals("Bug :(",
	// 2,productDAO.listActiveProductsByCategory(5).size());
	// }
	//
	@Test
	public void testGetLatestActiveProduct() {
		assertEquals("Bug :(!", 5, productDAO.getLatestActiveProducts(5).size());

	}

}
