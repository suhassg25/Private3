package com.ty.foodapp.foodapp_Spring_boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.ty.foodapp.foodapp_Spring_boot.dao.FoodOrderDao;
import com.ty.foodapp.foodapp_Spring_boot.dto.FoodOrder;
import com.ty.foodapp.foodapp_Spring_boot.service.FoodOrderService;
import com.ty.foodapp.foodapp_Spring_boot.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("foodOrder")
public class FoodOrderControl {

	@Autowired
	private FoodOrderService foodOrderService;

	@ApiOperation(value = "save FoodOrder", notes = "It is used to Save Food Order along with the Products")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "internal Server Error") })
	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<FoodOrder>> saveFoodOrder(@RequestBody FoodOrder foodOrder) {
		return foodOrderService.saveFood(foodOrder);
	}

	@ApiOperation(value = "fetch FoodOrder", notes = "It is used to Fetch Food Order along with the Products")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "internal Server Error") })
	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE })
	private ResponseEntity<ResponseStructure<FoodOrder>> getFoodOrder(@RequestParam int id) {
		return foodOrderService.getFoodOrder(id);
	}

	@ApiOperation(value = "update FoodOrder", notes = "It is used to update Food Order along with the Products")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "internal Server Error") })
	@PutMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<FoodOrder>> updateFoodOrder(@RequestBody FoodOrder foodOrder,
			@RequestParam int id) {
		return foodOrderService.updateFood(foodOrder, id);
	}

	@ApiOperation(value = "delete FoodOrder", notes = "It is used to Delete Food Order along with the Products")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "internal Server Error") })
	@DeleteMapping
	public ResponseEntity<ResponseStructure<String>> deleteFoodOrder(@RequestParam int id) {
		return foodOrderService.deleteFoodOrder(id);
	}
}
