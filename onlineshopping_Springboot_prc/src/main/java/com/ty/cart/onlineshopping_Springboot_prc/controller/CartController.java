package com.ty.cart.onlineshopping_Springboot_prc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.cart.onlineshopping_Springboot_prc.dto.Cart;
import com.ty.cart.onlineshopping_Springboot_prc.service.CartService;
import com.ty.cart.onlineshopping_Springboot_prc.util.ResponseStructure;

@RestController
public class CartController {

	
	@Autowired
	private CartService cartService;
	
	@PostMapping("cart")
	public ResponseStructure<Cart> saveCart(@RequestBody Cart cart)
	{
		return cartService.saveCart(cart);
	}
	
	@GetMapping("getcart")
	public ResponseStructure<Cart> getbyID(@RequestParam int id)
	{
		return cartService.getbyId(id);
	}
	
	@DeleteMapping("deletecart")
	public ResponseStructure<String> deletebyid(@RequestParam int id)
	{
		return cartService.deletebyId(id);
	}
	
	@PutMapping("updatecart")
	public ResponseStructure<Cart> update(@RequestParam int id, @RequestBody Cart cart)
	{
		return cartService.update(cart, id);
	}
}
