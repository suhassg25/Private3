package com.ty.foodapp.foodapp_Spring_boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.foodapp.foodapp_Spring_boot.dao.MenuDao;
import com.ty.foodapp.foodapp_Spring_boot.dto.Menu;
import com.ty.foodapp.foodapp_Spring_boot.exception.NotFoundIdException;
import com.ty.foodapp.foodapp_Spring_boot.exception.UnableToUpdateException;
import com.ty.foodapp.foodapp_Spring_boot.exception.UnbaleToDeleteException;
import com.ty.foodapp.foodapp_Spring_boot.util.ResponseStructure;

@Service
public class MenuService {

	@Autowired
	private MenuDao dao;
	
	public ResponseEntity<ResponseStructure<Menu>> saveMenu(Menu menu)
	{
		ResponseEntity<ResponseStructure<Menu>> entity;
		ResponseStructure<Menu> responseStructure=new ResponseStructure<Menu>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Saved");
		responseStructure.setData(dao.saveMenu(menu));
		return entity=new ResponseEntity<ResponseStructure<Menu>>(responseStructure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Menu>> updateMenu(Menu menu, int id)
	{
		ResponseEntity<ResponseStructure<Menu>> entity;
		Menu menu2=dao.getMenuById(id);
		
		ResponseStructure<Menu> responseStructure=new ResponseStructure<Menu>();
		if(menu2!=null)
		{
			menu.setId(id);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Updated");
			responseStructure.setData(dao.updateMenu(menu));
		}
		else
		{
			throw new UnableToUpdateException();
		}
		return entity=new ResponseEntity<ResponseStructure<Menu>>(responseStructure,HttpStatus.OK);
		
	}
	
	public ResponseEntity<ResponseStructure<Menu>> getMenu(int id)
	{
		ResponseEntity<ResponseStructure<Menu>> entity;
		Menu m1=dao.getMenuById(id);
		ResponseStructure<Menu>responseStructure=new ResponseStructure<Menu>();
if(m1!=null) {
	responseStructure.setStatus(HttpStatus.OK.value());
	responseStructure.setMessage("Found");
	responseStructure.setData(dao.getMenuById(id));	
}
else
{
	throw new NotFoundIdException();
}
return entity=new ResponseEntity<ResponseStructure<Menu>>(responseStructure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<String>> deleteMenu(int id)
	{
		ResponseEntity<ResponseStructure<String>> entity;
		Menu m1=dao.getMenuById(id);
		ResponseStructure<String>responseStructure=new ResponseStructure();
		if(m1!=null) {
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Deleted");
		responseStructure.setData(dao.deleteMenuById(id));	}
		else
		{
			throw new UnbaleToDeleteException();
		}
		return entity=new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.OK);		
	}
	
}
