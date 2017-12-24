package com.niit.frontshop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.niit.backshop.dao.CategoryDAO;
import com.niit.backshop.dao.ProductDAO;
import com.niit.backshop.dto.Category;
import com.niit.backshop.dto.Product;
import com.niit.frontshop.util.FileUploadUtility;

@Controller
@RequestMapping("/manage")
public class ManagementController {

	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private ProductDAO productDAO;

	private static final Logger logger = LoggerFactory.logger(ManagementController.class);

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ModelAndView showManageProducts(@RequestParam(name = "operation", required = false) String operation) {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickManageProducts", true);
		mv.addObject("title", "Manage Products");
		Product nProduct = new Product();
		nProduct.setSupplierId(1);
		nProduct.setActive(true);
		mv.addObject("product", nProduct);
		if (operation != null) {
			if (operation.equals("product")) {
				mv.addObject("message", "Sucess: Product Added! ");
			} else if (operation.equals("category")) {
				mv.addObject("message", "Sucess: Category Added! ");

			}
		}
		return mv;
	}

	@RequestMapping(value = "{id}/product", method = RequestMethod.GET)
	public ModelAndView showEditProduct(@PathVariable int id) {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickManageProducts", true);
		mv.addObject("title", "Manage Products");
		Product nProduct = productDAO.get(id);

		mv.addObject("product", nProduct);

		return mv;
	}

	// POST - to store products in db
	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public String storeProducts(@Valid @ModelAttribute("product") Product mProduct, BindingResult results, Model model,
			HttpServletRequest request) {

		// validate product attributes

		if (results.hasErrors()) {

			model.addAttribute("userClickManageProducts", true);
			model.addAttribute("title", "Manage Products");
			model.addAttribute("message", "Validation Failed !");
			return "page";
		}
		logger.info(mProduct.toString());

		if (mProduct.getId() == 0) {
			productDAO.add(mProduct);
		} else {
			productDAO.update(mProduct);
		}

		if (!mProduct.getFile().getOriginalFilename().equals("")) {
			FileUploadUtility.uploadFile(request, mProduct.getFile(), mProduct.getCode());
		}

		return "redirect:/manage/products?operation=product";
	}

	@RequestMapping(value = "/product/{id}/activation", method = RequestMethod.POST)
	@ResponseBody
	public String handleProductActivation(@PathVariable int id) {
		Product product = productDAO.get(id);
		boolean isActive = product.isActive();
		product.setActive(!product.isActive());
		productDAO.update(product);
		return (isActive) ? "Product Dectivated Successfully with id!" + product.getId()
				: "Product Activated Successfully with product id" + product.getId();
	}

	// category submission
	@RequestMapping(value = "/category", method = RequestMethod.POST)
	public String handleCategorySubmission(@ModelAttribute Category category) {
		categoryDAO.add(category);
		return "redirect:/manage/products?operation=category";
	}

	@ModelAttribute("categories")
	public List<Category> getCategories() {
		return categoryDAO.list();
	}

	@ModelAttribute("category")
	public Category getCategory() {
		return new Category();
	}
}
