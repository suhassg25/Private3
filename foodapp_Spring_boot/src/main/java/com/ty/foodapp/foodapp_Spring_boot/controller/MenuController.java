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

import com.ty.foodapp.foodapp_Spring_boot.dto.Menu;
import com.ty.foodapp.foodapp_Spring_boot.dto.User;
import com.ty.foodapp.foodapp_Spring_boot.service.MenuService;
import com.ty.foodapp.foodapp_Spring_boot.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("menu")
public class MenuController {

	@Autowired
	private MenuService menuService;

	@ApiOperation(value = "save Menu", notes = "It is Used to save Menu along with the Items")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "internal Server Error") })
	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Menu>> saveMenu(@RequestBody Menu menu) {
		return menuService.saveMenu(menu);
	}

	@ApiOperation(value = "fetch Menu", notes = "It is Used to fetch Menu along with the Items")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "internal Server Error") })
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseStructure<Menu>> getMenu(@RequestParam int id) {
		return menuService.getMenu(id);
	}

	@ApiOperation(value = "Update Menu", notes = "It is Used to Update Menu ")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "internal Server Error") })
	@PutMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Menu>> updateMenu(@RequestBody Menu menu, @RequestParam int id) {
		return menuService.updateMenu(menu, id);
	}

	@ApiOperation(value = "Delete Menu", notes = "It is Used to Delete Menu along with the Items")
	@ApiResponses(value = {@ApiResponse(code = 500, message = "internal Server Error")	})
	@DeleteMapping
	public ResponseEntity<ResponseStructure<String>> delete(@RequestParam int id) {
		return menuService.deleteMenu(id);
	}
}
