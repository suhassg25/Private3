package com.ty.emp.comany_Springboot_prc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.emp.comany_Springboot_prc.dto.Company;
import com.ty.emp.comany_Springboot_prc.service.CompanyService;
import com.ty.emp.comany_Springboot_prc.util.ResponseStructure;

@RestController
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;
	
	@PostMapping("saveCompany")
	public ResponseStructure<Company> saveCompany(@RequestBody Company company)
	{
		return companyService.saveCompany(company);
	}

	@GetMapping("getCompany")
	public ResponseStructure<Company> getCompany(@RequestParam int id)
	{
		return companyService.findById(id);
	}
	
	@DeleteMapping("deleteCompany")
	public ResponseStructure<String> delCompany(@RequestParam int id)
	{
	return companyService.deleteByID(id);	
	}
	
	@PutMapping("updateCompany")
	public ResponseStructure<Company> updateCompany(@RequestBody Company company ,@RequestParam int id)
	{
		return companyService.update(company, id);
	}
}
