package com.ty.foodapp.foodapp_Spring_boot.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.foodapp.foodapp_Spring_boot.dto.Product;
import com.ty.foodapp.foodapp_Spring_boot.repositery.ProductRepositery;

@Repository
public class ProductDao {

	@Autowired
	private ProductRepositery repositery;
	
	public Product saveProduct(Product product )
	{
		return repositery.save(product);
	}
	
	public Product updateProduct(Product product)
	{
		return repositery.save(product);
	}
	
	public Product getProductById(int id)
	{
		Optional<Product> optional=repositery.findById(id);
		if(optional.isEmpty())
		{
			return null;
		}
		else
		{
			return optional.get();
		}
	}
	
	public String deleteProductById(int id)
	{
		repositery.deleteById(id);
		return "Deleted";
	}
}
