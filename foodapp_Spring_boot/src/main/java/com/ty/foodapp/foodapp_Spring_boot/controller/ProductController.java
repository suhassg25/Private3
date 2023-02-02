package com.ty.foodapp.foodapp_Spring_boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.foodapp.foodapp_Spring_boot.dao.ProductDao;
import com.ty.foodapp.foodapp_Spring_boot.dto.Product;
import com.ty.foodapp.foodapp_Spring_boot.service.ProductService;
import com.ty.foodapp.foodapp_Spring_boot.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	
	@ApiOperation(value = "Update Products", notes = "It's used to update for Products")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "created"), @ApiResponse(code = 500, message = "internal server error")})
	
	@PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE	}, produces = {MediaType.APPLICATION_JSON_VALUE	})
	public ResponseEntity<ResponseStructure<Product>> updateProduct(@RequestBody Product product,@RequestParam int id)
	{
		return productService.updateProduct(product, id);
	}
	
	@ApiOperation(value = "fetch Products", notes = "It is used to fetch the Products Based on Id")
	@ApiResponses(value = {@ApiResponse(code = 500, message = "Internal Server Error")	})
	@GetMapping
	public ResponseEntity<ResponseStructure<Product>> getById(@RequestParam int id)
	{
		return productService.getById(id);
	}
	
	

}
