package com.ty.cart.onlineshopping_Springboot_prc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.cart.onlineshopping_Springboot_prc.dto.Items;
import com.ty.cart.onlineshopping_Springboot_prc.repositery.ItemsRepo;

@Repository
public class ItemsDao {


	@Autowired
	private ItemsRepo itemsRepo;
	
	public Items saveItems(Items item )
	{
		return itemsRepo.save(item);
	}
	
	public Items findByid(int id)
	{
		return itemsRepo.findById(id).get();
	}
	public String deletebyId(int id)
	{
		itemsRepo.deleteById(id);
		return null;
	}
}
