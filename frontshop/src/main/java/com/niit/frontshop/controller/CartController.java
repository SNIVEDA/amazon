package com.niit.frontshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.frontshop.service.CartService;

@Controller
@RequestMapping("cart")
public class CartController {

	@Autowired
	private CartService cartService;

	@RequestMapping(value = { "/show" })
	public ModelAndView showCart(@RequestParam(name = "result", required = false) String result) {
		ModelAndView mv = new ModelAndView("page");

		if (result != null) {
			switch (result) {
			case "updated":
				mv.addObject("message", "Update Success");
				break;
			case "deleted":
				mv.addObject("message", "Delete Success");
				break;
			case "error":
				mv.addObject("message", "Error :(");
				break;

			}
		}

		mv.addObject("title", "Cart");
		mv.addObject("userClickShowCart", true);
		mv.addObject("cartLines", cartService.getCartLines());
		return mv;
	}

	@RequestMapping("/{cartLineId}/update")
	public String updateCart(@PathVariable int cartLineId, @RequestParam int count) {

		String response = cartService.updateCartLine(cartLineId, count);

		return "redirect:/cart/show?" + response;
	}

	@RequestMapping("/{cartLineId}/remove")
	public String removeCart(@PathVariable int cartLineId) {

		String response = cartService.removeCartLine(cartLineId);

		return "redirect:/cart/show?" + response;
	}

	@RequestMapping("/add/{productId}/product")
	public String addCart(@PathVariable int productId) {

		String response = cartService.addCartLine(productId);

		return "redirect:/cart/show?" + response;
	}

}
