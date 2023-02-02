package com.ty.cart.onlineshopping_Springboot_prc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.cart.onlineshopping_Springboot_prc.dto.Cart;
import com.ty.cart.onlineshopping_Springboot_prc.repositery.CarRepositery;

@Repository
public class CartDao {

	@Autowired
	private CarRepositery carRepositery;
	
	public Cart saveCart(Cart cart )
	{
		return carRepositery.save(cart);
	}
	
	
	public Cart getbyId(int id)
	{
		return carRepositery.findById(id).get();
	}
	
	public String delete(int id)
	{
		 carRepositery.deleteById(id);
		return null;
	}
}
