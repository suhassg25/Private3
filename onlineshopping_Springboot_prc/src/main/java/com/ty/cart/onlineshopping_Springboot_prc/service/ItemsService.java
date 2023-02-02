package com.ty.cart.onlineshopping_Springboot_prc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.ty.cart.onlineshopping_Springboot_prc.dao.CartDao;
import com.ty.cart.onlineshopping_Springboot_prc.dao.ItemsDao;
import com.ty.cart.onlineshopping_Springboot_prc.dto.Cart;
import com.ty.cart.onlineshopping_Springboot_prc.dto.Items;
import com.ty.cart.onlineshopping_Springboot_prc.util.ResponseStructure;

@Service
public class ItemsService {

	@Autowired
	private ItemsDao dao;

	@Autowired
	private CartDao cartDao;

	public ResponseStructure<Items> saveItem(Items item, int id) {
		ResponseStructure<Items> responseStructure = new ResponseStructure<Items>();
		Cart cart = cartDao.getbyId(id);
		if(cart!=null)
		{
		item.setCart(cart);
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Saved");
		responseStructure.setData(dao.saveItems(item));
		}
		return responseStructure;

	}

	public ResponseStructure<Items> findItem(int id) {

		ResponseStructure<Items> responseStructure = new ResponseStructure<Items>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Recieved");
		responseStructure.setData(dao.findByid(id));
		return responseStructure;

	}

	public ResponseStructure<String> deletebyID(int id) {

		ResponseStructure<String> responseStructure = new ResponseStructure();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Deleted");
		responseStructure.setData(dao.deletebyId(id));
		return responseStructure;

	}
	public ResponseStructure<Items> update(Items item, int id)
	{
		ResponseStructure<Items> responseStructure = new ResponseStructure();
		Items i1=dao.findByid(id);
		if(i1!=null)
		{
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Updated");
			responseStructure.setData(dao.saveItems(item));
		}
			
		return responseStructure;
	}

}
