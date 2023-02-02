package com.ty.foodapp.foodapp_Spring_boot.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.foodapp.foodapp_Spring_boot.dto.User;
import com.ty.foodapp.foodapp_Spring_boot.service.UserService;
import com.ty.foodapp.foodapp_Spring_boot.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private UserService service;

	@ApiOperation(value = "save Food Order", notes = "It's used to save for Food")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "created"), @ApiResponse(code = 500, message = "internal server error")})
	
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE	}, produces = {MediaType.APPLICATION_JSON_VALUE	})
	public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody @Valid User user)
	{
		return service.saveUser(user);
	}
	
	@ApiOperation(value = "updates User", notes = "It's used to Update the user")
	@ApiResponses(value = {@ApiResponse(code = 500, message = "Internal Server Error"), @ApiResponse(code = 404, message = "Not found")	})
	@PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ResponseStructure<User>> updateUser(@RequestBody User user, @RequestParam int id)
	{
		return service.updateUser(user, id);
	}
	
	@ApiOperation(value = "Deletes users", notes = "It's Used to delete User")
	@ApiResponses(value = {@ApiResponse(code = 500, message = "Internal server Error")})
	@DeleteMapping
	public ResponseEntity<ResponseStructure<String>> deleteUser(@RequestParam int id)
	{
		return service.deleteById(id);
	}
	@ApiOperation(value = "Fetches users", notes = "It's Used to fetch the User")
	@ApiResponses(value = {@ApiResponse(code = 500, message = "Internal server Error")})
	@GetMapping
	public ResponseEntity<ResponseStructure<User>> getUserById(@RequestParam int id)
	{
		return service.getById(id);
	}
	
}
