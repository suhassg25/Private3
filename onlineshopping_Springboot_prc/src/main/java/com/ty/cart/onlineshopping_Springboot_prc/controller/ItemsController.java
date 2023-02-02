package com.ty.cart.onlineshopping_Springboot_prc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.cart.onlineshopping_Springboot_prc.dao.CartDao;
import com.ty.cart.onlineshopping_Springboot_prc.dto.Cart;
import com.ty.cart.onlineshopping_Springboot_prc.dto.Items;
import com.ty.cart.onlineshopping_Springboot_prc.service.CartService;
import com.ty.cart.onlineshopping_Springboot_prc.service.ItemsService;
import com.ty.cart.onlineshopping_Springboot_prc.util.ResponseStructure;

@RestController
public class ItemsController {
	
	@Autowired
	private ItemsService itemsService;
	
		
	@PostMapping("items")
	public ResponseStructure<Items> saveItem(@RequestBody Items item, @RequestParam int id)
	{
		
		return itemsService.saveItem(item, id);
	}
	
	@GetMapping("getItems")
	public ResponseStructure<Items> getItemsbyID(@RequestParam int id)
	{
		return itemsService.findItem(id);
	}

	@DeleteMapping("deleteItems")
	public ResponseStructure<String> deleteItemById(@RequestParam int id)
	{
		return itemsService.deletebyID(id);
	}
	
	@PutMapping("updateItem")
	public ResponseStructure<Items> update(@RequestBody Items item, @RequestParam int id)
	{
		return itemsService.update(item, id);
	}
	{
		
	}
}
