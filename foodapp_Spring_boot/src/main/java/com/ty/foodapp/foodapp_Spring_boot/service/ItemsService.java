package com.ty.foodapp.foodapp_Spring_boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.foodapp.foodapp_Spring_boot.dao.ItemsDao;
import com.ty.foodapp.foodapp_Spring_boot.dao.MenuDao;
import com.ty.foodapp.foodapp_Spring_boot.dto.Items;
 import com.ty.foodapp.foodapp_Spring_boot.exception.NotFoundIdException;
import com.ty.foodapp.foodapp_Spring_boot.exception.UnableToUpdateException;
import com.ty.foodapp.foodapp_Spring_boot.exception.UnbaleToDeleteException;
import com.ty.foodapp.foodapp_Spring_boot.util.ResponseStructure;

@Service
public class ItemsService {

	@Autowired
	private ItemsDao dao;

	@Autowired
	private MenuDao dao2;

	public ResponseEntity<ResponseStructure<Items>> saveItems(Items items) {
		ResponseEntity<ResponseStructure<Items>> entity;
		ResponseStructure<Items> responseStructure = new ResponseStructure<Items>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Saved");
		responseStructure.setData(dao.saveItems(items));
		return entity=new ResponseEntity<ResponseStructure<Items>>(responseStructure,HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Items>> updateItems(Items items, int id) {
		ResponseEntity<ResponseStructure<Items>>entity;
		Items items2 = dao.getItemsById(id);

		ResponseStructure<Items> responseStructure = new ResponseStructure<Items>();
		if (items2 != null) {
			items.setId(id);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Updated");
			responseStructure.setData(dao.updateItems(items));
		} else {
			throw new UnableToUpdateException();
		}
		return entity=new ResponseEntity<ResponseStructure<Items>>(responseStructure,HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Items>> getItems(int id) {
		ResponseEntity<ResponseStructure<Items>> entity;
		Items item2 = dao.getItemsById(id);
		ResponseStructure<Items> responseStructure = new ResponseStructure<>();
		if (item2 != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Found");
			responseStructure.setData(dao.getItemsById(id));
		} else {
			throw new NotFoundIdException();
		}
		return entity=new ResponseEntity<ResponseStructure<Items>>(responseStructure,HttpStatus.OK);	}

	public ResponseEntity<ResponseStructure<String>> deleteItems(int id) {
		ResponseEntity<ResponseStructure<String>> entity;
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();

		Items item2 = dao.getItemsById(id);
		if (item2 != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Deleted");
			responseStructure.setData(dao.deleteItemsById(id));
		} else {
			throw new UnbaleToDeleteException();
		}
		return entity=new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.OK);	}
}
