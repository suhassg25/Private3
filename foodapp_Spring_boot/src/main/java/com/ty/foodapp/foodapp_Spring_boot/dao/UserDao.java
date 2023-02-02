package com.ty.foodapp.foodapp_Spring_boot.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.foodapp.foodapp_Spring_boot.dto.User;
import com.ty.foodapp.foodapp_Spring_boot.repositery.UserRepositery;

@Repository
public class UserDao {
	
	@Autowired
	private UserRepositery repositery;
	
	public User saveUser(User user)
	{
		return repositery.save(user);
	}
	
	public User updateUser(User user)
	{
		return repositery.save(user);
	}
	
	public User getUserById(int id)
	{
		Optional<User> optional=repositery.findById(id);
		if(optional.isEmpty())
		{
			return null;
		}
		else
		{
			return optional.get();
		}
	}
	
	public String deleteUserById(int id)
	{
		repositery.deleteById(id);
		return "Deleted";
	}
	

}
