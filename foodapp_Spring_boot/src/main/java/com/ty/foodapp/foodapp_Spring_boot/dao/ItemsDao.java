package com.ty.foodapp.foodapp_Spring_boot.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.foodapp.foodapp_Spring_boot.dto.Items;
import com.ty.foodapp.foodapp_Spring_boot.repositery.ItemsRepositery;

@Repository
public class ItemsDao {

	@Autowired
	private ItemsRepositery repositery;
	
	public Items saveItems(Items item)
	{
		return repositery.save(item);
	}
	
	public Items updateItems(Items item)
	{
		return repositery.save(item);
	}
	
	public Items getItemsById(int id)
	{
		Optional<Items> optional=repositery.findById(id);
		if(optional.isEmpty())
		{
			return null;
		}
		else
		{
			return optional.get();
		}
	}
	
	public String deleteItemsById(int id)
	{
		repositery.deleteById(id);
		return "Deleted";
	}
	
}
