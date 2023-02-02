package com.ty.cart.onlineshopping_Springboot_prc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import com.ty.cart.onlineshopping_Springboot_prc.dao.CartDao;
import com.ty.cart.onlineshopping_Springboot_prc.dto.Cart;
import com.ty.cart.onlineshopping_Springboot_prc.util.ResponseStructure;

@Service
public class CartService {

	
	@Autowired
	private CartDao cartDao;
	
	
	
	public ResponseStructure<Cart> saveCart(Cart cart)
	{
		ResponseStructure<Cart> responseStructure=new ResponseStructure();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Saved");
		responseStructure.setData(cartDao.saveCart(cart));
		return responseStructure;
	}
	
	public ResponseStructure<Cart> getbyId(int id)
	{
		ResponseStructure<Cart> responseStructure=new ResponseStructure();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Recieved");
		responseStructure.setData(cartDao.getbyId(id));
		return responseStructure;
	}
	
	public ResponseStructure<String> deletebyId(int id)
	{
		ResponseStructure<String> responseStructure=new ResponseStructure();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Deleted");
		responseStructure.setData(cartDao.delete(id));
		return responseStructure;
	}
	
	public ResponseStructure<Cart> update(Cart cart, int id)
	{
		ResponseStructure<Cart> responseStructure=new ResponseStructure();
		Cart c=cartDao.getbyId(id);
		if(c!=null)
		{	cart.setId(id);
			responseStructure.setStatus(HttpStatus.OK.value());	
			responseStructure.setMessage("Updated");
			responseStructure.setData(cartDao.saveCart(cart));
		}
		return responseStructure;
	}
}
