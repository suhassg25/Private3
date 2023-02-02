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

import com.ty.foodapp.foodapp_Spring_boot.dto.Items;
import com.ty.foodapp.foodapp_Spring_boot.service.ItemsService;
import com.ty.foodapp.foodapp_Spring_boot.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("items")
public class ItemsController {

	@Autowired
	private ItemsService service;

	@ApiOperation(value = "Update Items", notes = "It is Used to Update Items")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "internal Server Error") })
	@PutMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Items>> updateItems(@RequestBody Items items, @RequestParam int id) {
		return service.updateItems(items, id);
	}

	@ApiOperation(value = "Fetch Items", notes = "It is Used to Fetch Items based on ID")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "internal Server Error") })
	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ResponseStructure<Items>> getItems(@RequestParam int id) {
		return service.getItems(id);
	}
}
