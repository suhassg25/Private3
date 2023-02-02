package com.ty.foodapp.foodapp_Spring_boot.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.foodapp.foodapp_Spring_boot.dto.Menu;
import com.ty.foodapp.foodapp_Spring_boot.repositery.MenuRepositery;

@Repository
public class MenuDao {

	@Autowired
	private MenuRepositery repositery;
	
	public Menu saveMenu(Menu menu )
	{
		return repositery.save(menu);
	}
	
	public Menu updateMenu(Menu menu)
	{
		return repositery.save(menu);
	}
	
	public Menu getMenuById(int id)
	{
		Optional<Menu> optional=repositery.findById(id);
		if(optional.isEmpty())
		{
			return null;
		}
		else
		{
			return optional.get();
		}
	}
	
	public String deleteMenuById(int id)
	{
		repositery.deleteById(id);
		return "Deleted";
	}
}
