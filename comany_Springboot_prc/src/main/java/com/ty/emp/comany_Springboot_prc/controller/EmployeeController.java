package com.ty.emp.comany_Springboot_prc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.emp.comany_Springboot_prc.dto.Employee;
import com.ty.emp.comany_Springboot_prc.service.EmployeeService;
import com.ty.emp.comany_Springboot_prc.util.ResponseStructure;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("saveEmployee")
	public ResponseStructure<Employee> saveEmployee(@RequestBody Employee employee, @RequestParam int id)
	{
		return employeeService.saveEmployee(employee, id);
		}
	
	
	@GetMapping("getEmployee")
	public ResponseStructure<Employee> getEmployee(@RequestParam int id)
	{
	return employeeService.getEmployee(id);	
	}
	
	@DeleteMapping("deleteEmployee/{id}")
	public ResponseStructure<String> deleteEmp(@PathVariable int id) 
	{
		return employeeService.deletById(id);
	}
	
	@PutMapping("updateEmployee")
	public ResponseStructure<Employee> update(@RequestBody Employee employee, @RequestParam int id)
	{
		return employeeService.updateEmp(employee, id);
	}
}
