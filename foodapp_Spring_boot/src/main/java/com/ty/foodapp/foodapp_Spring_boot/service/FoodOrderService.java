package com.ty.foodapp.foodapp_Spring_boot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.foodapp.foodapp_Spring_boot.dao.FoodOrderDao;
import com.ty.foodapp.foodapp_Spring_boot.dto.FoodOrder;
import com.ty.foodapp.foodapp_Spring_boot.dto.Product;
import com.ty.foodapp.foodapp_Spring_boot.exception.NotFoundIdException;
import com.ty.foodapp.foodapp_Spring_boot.exception.UnableToUpdateException;
import com.ty.foodapp.foodapp_Spring_boot.exception.UnbaleToDeleteException;
import com.ty.foodapp.foodapp_Spring_boot.util.ResponseStructure;

@Service
public class FoodOrderService {

	@Autowired
	private FoodOrderDao dao;
	
	public ResponseEntity<ResponseStructure<FoodOrder>> saveFood(FoodOrder foodOrder)
	{
		ResponseEntity<ResponseStructure<FoodOrder>> entity;
		List<Product> list=foodOrder.getProducts();
		double totalcost=0;
		for(Product p : list)
		{
			totalcost=totalcost+(p.getQuantity()*p.getPrice());
		}
		totalcost=totalcost+(totalcost*0.18);
		foodOrder.setTotalcost(totalcost);		
		ResponseStructure<FoodOrder> responseStructure= new ResponseStructure<FoodOrder>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Saved");
		responseStructure.setData(dao.saveFoodOrder(foodOrder));
		return entity=new ResponseEntity<ResponseStructure<FoodOrder>>(responseStructure,HttpStatus.OK);
		
	}
	
	public ResponseEntity<ResponseStructure<FoodOrder>> updateFood(FoodOrder foodOrder, int id)
	{
		ResponseEntity<ResponseStructure<FoodOrder>> entity;
		ResponseStructure<FoodOrder> responseStructure= new ResponseStructure<FoodOrder>();
		FoodOrder foodOrder2=dao.getFoodOrderbyId(id);
		if(foodOrder2!=null)
		{
			List<Product> list=foodOrder.getProducts();
			double totalcost=0;
			for(Product p : list)
			{
				totalcost=totalcost+(p.getQuantity()*p.getPrice());
			}
			totalcost=totalcost+(totalcost*0.18);
			foodOrder.setTotalcost(totalcost);		
			foodOrder.setId(id);
			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setMessage("Updated");
			responseStructure.setData(dao.updateFoodOrder(foodOrder));
		}
		else
		{
			throw new UnableToUpdateException();
		}
		
		return entity=new ResponseEntity<ResponseStructure<FoodOrder>>(responseStructure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<String>> deleteFoodOrder(int id)
	{
		ResponseEntity<ResponseStructure<String>> entity;
		ResponseStructure<String> responseStructure= new ResponseStructure<>();
		FoodOrder foodOrder2=dao.getFoodOrderbyId(id);
		if(foodOrder2!=null)
		{
			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setMessage("Deleted");
			responseStructure.setData(dao.deleteFoodOrderbyId(id));
		}
		else
		{
			throw new UnbaleToDeleteException();
		}
		
		return entity=new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<FoodOrder>> getFoodOrder(int id)
	{
		ResponseEntity<ResponseStructure<FoodOrder>> entity;
		ResponseStructure<FoodOrder> responseStructure= new ResponseStructure<FoodOrder>();
		FoodOrder foodOrder2=dao.getFoodOrderbyId(id);
		if(foodOrder2!=null)
		{
			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setMessage("Found");
			responseStructure.setData(dao.getFoodOrderbyId(id));
		}
		else
		{
			throw new NotFoundIdException();
		}
		
		return entity=new ResponseEntity<ResponseStructure<FoodOrder>>(responseStructure,HttpStatus.OK);
	}
}
