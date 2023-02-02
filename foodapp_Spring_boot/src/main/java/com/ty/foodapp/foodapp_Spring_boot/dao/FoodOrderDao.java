package com.ty.foodapp.foodapp_Spring_boot.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.foodapp.foodapp_Spring_boot.dto.FoodOrder;
import com.ty.foodapp.foodapp_Spring_boot.repositery.FoodOrderRepositery;

@Repository
public class FoodOrderDao {

	@Autowired
	private FoodOrderRepositery repositery;
	
	public FoodOrder saveFoodOrder(FoodOrder foodOrder)
	{
		return repositery.save(foodOrder);
	}
	public FoodOrder updateFoodOrder(FoodOrder foodOrder)
	{
		return repositery.save(foodOrder);
	}
	public FoodOrder getFoodOrderbyId(int id)
	{
		Optional<FoodOrder> optional=repositery.findById(id);
		if(optional.isPresent())
		{
			return optional.get();
		}
		return null;
	}
	
	public String deleteFoodOrderbyId(int id)
	{
		repositery.deleteById(id);
		return "deleted";
	}
	
}
