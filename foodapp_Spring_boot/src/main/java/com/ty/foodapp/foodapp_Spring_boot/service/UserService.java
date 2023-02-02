package com.ty.foodapp.foodapp_Spring_boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.foodapp.foodapp_Spring_boot.dao.UserDao;
import com.ty.foodapp.foodapp_Spring_boot.dto.User;
import com.ty.foodapp.foodapp_Spring_boot.exception.NotFoundIdException;
import com.ty.foodapp.foodapp_Spring_boot.exception.UnableToUpdateException;
import com.ty.foodapp.foodapp_Spring_boot.exception.UnbaleToDeleteException;
import com.ty.foodapp.foodapp_Spring_boot.util.ResponseStructure;

@Service
public class UserService {

	@Autowired
	private UserDao dao;

	public ResponseEntity<ResponseStructure<User>> saveUser(User user) {
		ResponseEntity<ResponseStructure<User>> entity;
		ResponseStructure<User> responseStructure = new ResponseStructure<User>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Saved");
		responseStructure.setData(dao.saveUser(user));
		return entity=new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<User>> updateUser(User user, int id) {
		ResponseEntity<ResponseStructure<User>> entity;
		User user2 = dao.getUserById(id);
		ResponseStructure<User> responseStructure = new ResponseStructure<User>();
		if (user2 != null) {
			user.setId(id);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Updated");
			responseStructure.setData(dao.updateUser(user));
		} else {
			
			throw new UnableToUpdateException();
		}

		return entity= new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<String>> deleteById(int id) {
	
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		ResponseEntity<ResponseStructure<String>> entity;
		User user = dao.getUserById(id);
		if (user != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Deleted");
			responseStructure.setData(dao.deleteUserById(id));

		} else {
			// throw new NotFoundIdException("Invalid ID");
				throw new UnbaleToDeleteException();
		}
		return entity=new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<User>> getById(int id) {
		
		ResponseEntity<ResponseStructure<User>> entity;
		ResponseStructure<User> responseStructure = new ResponseStructure<User>();
		User user = dao.getUserById(id);
		if (user != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Found");
			responseStructure.setData(dao.getUserById(id));
		} else {
			// throw new NotFoundIdException("Invalid ID");
			throw new NotFoundIdException();
		}
		return entity=new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.OK);
	}
}
